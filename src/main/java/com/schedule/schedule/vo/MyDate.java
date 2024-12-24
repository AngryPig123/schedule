package com.schedule.schedule.vo;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.schedule.schedule.util.CommonUtil.DATE_TIM_FORMATTERS;

/**
 * packageName    : com.schedule.schedule.vo
 * fileName       : Date
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Alias("MyDate")
@Getter
@ToString
@EqualsAndHashCode
public class MyDate {
    private final String date;

    private MyDate(String date) {
        this.date = date;
    }

    public static MyDate of(String date) {
        return new MyDate(date);
    }

    public LocalDate toLocalDate() {
        for (DateTimeFormatter formatter : DATE_TIM_FORMATTERS) {
            try {
                return LocalDate.parse(this.date, formatter);
            } catch (DateTimeParseException ignored) {

            }
        }
        throw new IllegalArgumentException("Invalid date format: " + this.date);
    }

}
