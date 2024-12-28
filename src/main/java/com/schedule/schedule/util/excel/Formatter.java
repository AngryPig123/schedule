package com.schedule.schedule.util.excel;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.schedule.schedule.util.excel
 * fileName       : Formatter
 * author         : AngryPig123
 * date           : 24. 12. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 29.        AngryPig123       최초 생성
 */
@Getter
@AllArgsConstructor
public enum Formatter {
    DEFAULT(""),
    DECIMAL("###,###.##");
    private final String pattern;
}
