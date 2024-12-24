package com.schedule.schedule.util;

import com.schedule.schedule.constants.PasswordEncryptType;
import com.schedule.schedule.type.ProjectLocalDateTimeFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.schedule.schedule.util.DateUtil.format;
import static com.schedule.schedule.util.DateUtil.parse;
import static com.schedule.schedule.util.LoggingUtil.defaultLogging;
import static com.schedule.schedule.util.ObjectUtil.defaultCopyObject;
import static com.schedule.schedule.util.PasswordEncoderFactory.findPasswordEncoderByPasswordEncryptType;


/**
 * packageName    : com.schedule.schedule.util
 * fileName       : CommonUtilService
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Slf4j
public class CommonUtil {

    public static void logging(LogLevel level, Object... objects) {
        defaultLogging(level, objects);
    }

    public static String localDateTimeToString(LocalDateTime dateTime, ProjectLocalDateTimeFormat projectLocalDateTimeFormat) {
        return format(dateTime, projectLocalDateTimeFormat);
    }

    public static LocalDateTime stringToLocalDateTime(String dateTimeStr, ProjectLocalDateTimeFormat projectLocalDateTimeFormat) {
        return parse(dateTimeStr, projectLocalDateTimeFormat);
    }

    public static void copyObject(Object resource, Object target) {
        defaultCopyObject(resource, target);
    }

    public static final List<DateTimeFormatter> DATE_TIM_FORMATTERS = List.of(
            DateTimeFormatter.ofPattern("yyyyMMdd"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
    );

    public static PasswordEncoder getPasswordEncoder(PasswordEncryptType passwordEncryptType) {
        return findPasswordEncoderByPasswordEncryptType(passwordEncryptType);
    }

}
