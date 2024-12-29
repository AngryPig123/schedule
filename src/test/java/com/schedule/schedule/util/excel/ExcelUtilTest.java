package com.schedule.schedule.util.excel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.schedule.schedule.util.excel
 * fileName       : ExcelUtilTest
 * author         : AngryPig123
 * date           : 24. 12. 28.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 28.        AngryPig123       최초 생성
 */
@Slf4j
class ExcelUtilTest {


    @Getter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ExcelTest2 {

        @ExcelField(columnName = "헤더 1", width = 20, backgroundColor = Color.BLUE)
        private String name;

        @ExcelField(columnName = "헤더 2", backgroundColor = Color.RED)
        private int age;

        @ExcelField(columnName = "헤더 3", format = Formatter.DECIMAL, backgroundColor = Color.GREEN)
        private String city;

        @ExcelField(columnName = "헤더 4", backgroundColor = Color.BLACK)
        private boolean isActive;

        @ExcelField(columnName = "헤더 5", format = Formatter.DECIMAL, backgroundColor = Color.WHITE)
        private double score;

        private ExcelTest2(String name, int age, String city, boolean isActive, double score) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.isActive = isActive;
            this.score = score;
        }

        public static ExcelTest2 of(String name, int age, String city, boolean isActive, double score) {
            return new ExcelTest2(name, age, city, isActive, score);
        }
    }


    @Test
    void excelDownloadTest() {
        List<ExcelTest2> list = List.of(
                ExcelTest2.of("테스트1테스트1테스트1테스트1테스트1테스트1테스트1테스트1", 25, "서울", true, 88.5),
                ExcelTest2.of("테스트2", 30, "부산", false, 92.0),
                ExcelTest2.of("테스트3", 28, "대구", true, 75.4),
                ExcelTest2.of("테스트4", 35, "인천", true, 89.8),
                ExcelTest2.of("테스트5", 22, "광주", false, 95.1),
                ExcelTest2.of("테스트6", 40, "대전", true, 60.3),
                ExcelTest2.of("테스트7", 29, "울산", false, 78.9),
                ExcelTest2.of("테스트8", 33, "세종", true, 82.2),
                ExcelTest2.of("테스트9", 27, "경기", false, 91.5),
                ExcelTest2.of("테스트10", 31, "강원", true, 2000000.32)
        );
        File test = ExcelUtil.createFile(list, "src/test/resources/test.xlsx", "test");

    }

}