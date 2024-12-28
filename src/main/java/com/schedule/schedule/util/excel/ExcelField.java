package com.schedule.schedule.util.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName    : com.schedule.schedule.util.excel
 * fileName       : ExcelField
 * author         : AngryPig123
 * date           : 24. 12. 28.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 28.        AngryPig123       최초 생성
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    String columnName() default "";

    int width() default 10; // 기본 너비 10

    Color backgroundColor() default Color.WHITE;

    @Deprecated
    Color fontColor() default Color.BLACK;

    Formatter format() default Formatter.DEFAULT;

}
