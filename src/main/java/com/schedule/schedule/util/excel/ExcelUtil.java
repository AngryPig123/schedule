package com.schedule.schedule.util.excel;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * packageName    : com.schedule.schedule.util.excel
 * fileName       : ExcelUtil
 * author         : AngryPig123
 * date           : 24. 12. 28.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 28.        AngryPig123       최초 생성
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelUtil {

    private static final int DEFAULT_COLUMN_WIDTH = 256;

    public static <T> File createFile(List<T> dataList, String filePath, String sheetName) {
        try (Workbook workbook = createWorkbook()) {
            Sheet sheet = createSheet(workbook, sheetName);
            bindDataToSheet(workbook, sheet, dataList);
            return createFile(workbook, filePath);
        } catch (IOException ioe) {
            log.error("excel upload fail ", ioe);
            return null;
        }
    }

    public static void responseExcelFile(Workbook workbook, HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=workbook.xlsx");
            workbook.write(response.getOutputStream());
        } catch (IOException ioe) {
            log.error("Error writing Excel file to response", ioe);
        } finally {
            closeWorkbook(workbook);
        }
    }

    private static Workbook createWorkbook() {
        return new XSSFWorkbook();
    }

    private static Sheet createSheet(Workbook workbook) {
        return workbook.createSheet();
    }

    private static Sheet createSheet(Workbook workbook, String sheetName) {
        return workbook.createSheet(sheetName);
    }

    private static <T> void bindDataToSheet(Workbook workbook, Sheet sheet, List<T> bindData) {
        if (bindData == null || bindData.isEmpty()) return;
        Field[] fields = getFieldsFromFirstElement(bindData);
        if (hasHeader(bindData)) setHeaderData(workbook, sheet, fields);
        setBodyData(sheet, bindData, fields);
    }

    private static <T> boolean hasHeader(List<T> bindData) {
        Field[] fields = getFieldsFromFirstElement(bindData);
        for (Field field : fields) {
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            if (excelField != null && !excelField.columnName().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static <T> Field[] getFieldsFromFirstElement(List<T> bindData) {
        T firstElement = bindData.get(0);
        return firstElement.getClass().getDeclaredFields();
    }

    private static void setHeaderData(Workbook workbook, Sheet sheet, Field[] fields) {
        Row headerRow = sheet.createRow(0);
        int colIndex = 0;

        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = getColumnName(field);
            Cell cell = headerRow.createCell(colIndex);
            cell.setCellValue(columnName);

            int columnWidth = getColumnWidth(field);
            sheet.setColumnWidth(colIndex, columnWidth);

            /* 배경색 설정 */
            Color backGroundColor = getColumnBackGroundColor(field);
            java.awt.Color bgColor = Color.hexToAwtColor(backGroundColor);
            CellStyle cellStyle = workbook.createCellStyle();
            XSSFColor xssBgfColor = new XSSFColor(bgColor, null);
            cellStyle.setFillForegroundColor(xssBgfColor);
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell.setCellStyle(cellStyle);

            colIndex++;
        }
    }

    private static <T> void setBodyData(Sheet sheet, List<T> bindData, Field[] fields) {
        IntStream.range(0, bindData.size()).forEach(rowIndex -> {
            T data = bindData.get(rowIndex);
            Row row = sheet.createRow(rowIndex + 1);
            IntStream.range(0, fields.length).forEach(colIndex -> {

                Field field = fields[colIndex];
                field.setAccessible(true);
                Cell cell = row.createCell(colIndex);
                Object value = ReflectionUtils.getField(field, data);

                Formatter columnFormatter = getColumnFormatter(field);
                if (columnFormatter != Formatter.DEFAULT) {
                    value = String.valueOf(value);
                    DecimalFormat decimalFormat = new DecimalFormat(columnFormatter.getPattern());
                    try {
                        value = decimalFormat.format(Double.parseDouble(value.toString()));
                    } catch (NumberFormatException npe) {
                        log.info("[{}]데이터 변환 실패 원본 데이터로 반환됩니다.", value);
                    }
                }

                setCellValue(value, cell);
                int columnWidth = getColumnWidth(field);
                sheet.setColumnWidth(colIndex, columnWidth);

            });
        });
    }

    private static void setCellValue(Object value, Cell cell) {


        if (value != null) {
            if (value instanceof Number) {
                cell.setCellValue(((Number) value).doubleValue());
            } else if (value instanceof Boolean) {
                cell.setCellValue((Boolean) value);
            } else {
                cell.setCellValue(value.toString());
            }
        }

    }

    private static String getColumnName(Field field) {
        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (excelField != null && !excelField.columnName().isEmpty()) {
            return excelField.columnName();
        } else {
            return field.getName();
        }
    }

    private static int getColumnWidth(Field field) {
        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (excelField != null && excelField.width() != 10) {
            return excelField.width() * DEFAULT_COLUMN_WIDTH;
        } else {
            return 10 * DEFAULT_COLUMN_WIDTH;
        }
    }

    private static Color getColumnBackGroundColor(Field field) {
        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (excelField != null && excelField.backgroundColor() != Color.WHITE) {
            return excelField.backgroundColor();
        } else {
            return Color.WHITE;
        }
    }

    private static Color getColumnFontColor(Field field) {
        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (excelField != null && excelField.fontColor() != Color.BLACK) {
            return excelField.fontColor();
        } else {
            return Color.BLACK;
        }
    }

    private static Formatter getColumnFormatter(Field field) {
        ExcelField excelField = field.getAnnotation(ExcelField.class);
        if (excelField != null && excelField.format() != Formatter.DEFAULT) {
            return excelField.format();
        } else {
            return Formatter.DEFAULT;
        }
    }

    private static void closeWorkbook(Workbook workbook) {
        if (workbook != null) {
            try {
                workbook.close();
            } catch (IOException ioe) {
                log.error("Error closing workbook", ioe);
            }
        }
    }

    private static File createFile(Workbook workbook, String filePath) {
        File file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (IOException ioe) {
            log.error("Failed to write Excel workbook to file: " + filePath, ioe);
            return null;
        } finally {
            try {
                workbook.close();
            } catch (IOException ioe) {
                log.error("Error closing workbook", ioe);
            }
        }
        return file;
    }

}