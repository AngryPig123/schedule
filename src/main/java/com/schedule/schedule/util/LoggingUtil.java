package com.schedule.schedule.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

import java.util.Arrays;
import java.util.Objects;

/**
 * packageName    : com.schedule.schedule.util
 * fileName       : StaticUtil
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Slf4j
public class LoggingUtil {

    static void defaultLogging(LogLevel level, Object... objects) {
        Arrays.stream(objects).forEach(target -> {
            String content = Objects.isNull(target) ? "null" : target.toString();
            switch (level) {
                case DEBUG:
                    log.debug("content = {}", content);
                    break;
                case WARN:
                    log.warn("content = {}", content);
                    break;
                case ERROR:
                    log.error("content = {}", content);
                    break;
                case TRACE:
                    log.trace("content = {}", content);
                    break;
                case INFO:
                default:
                    log.info("content = {}", content);
                    break;
            }
        });
    }

}
