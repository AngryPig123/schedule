package com.schedule.schedule.util;

import com.schedule.schedule.type.ProjectLocalDateTimeFormat;
import com.schedule.schedule.type.ProjectLocalDateTimeFormatter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName    : com.schedule.schedule.util
 * fileName       : DateUtil
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Slf4j
public class DateUtil {

    static private DateTimeFormatter getDateTimeFormatter(ProjectLocalDateTimeFormat projectLocalDateTimeFormat) {
        if (ProjectLocalDateTimeFormat.DEFAULT == projectLocalDateTimeFormat) {
            return DateTimeFormatter.ofPattern(ProjectLocalDateTimeFormatter.YYYY_MM_DD_HH_MM_SS.getFormat());
        }
        if (ProjectLocalDateTimeFormat.KOREAN == projectLocalDateTimeFormat) {
            return DateTimeFormatter.ofPattern(ProjectLocalDateTimeFormatter.YYYY_MM_DD_HH_MM_SS_KR.getFormat());
        }
        throw new RuntimeException();
    }

    static String format(LocalDateTime dateTime, ProjectLocalDateTimeFormat projectLocalDateTimeFormat) {
        return dateTime.format(getDateTimeFormatter(projectLocalDateTimeFormat));
    }

    static LocalDateTime parse(String dateTimeStr, ProjectLocalDateTimeFormat projectLocalDateTimeFormat) {
        return LocalDateTime.parse(dateTimeStr, getDateTimeFormatter(projectLocalDateTimeFormat));
    }


}
