package com.schedule.schedule.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.schedule.schedule.type
 * fileName       : ProjectRegex
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Getter
@AllArgsConstructor
public enum ProjectRegex {
    PHONE("^010-[0-9]{4}-[0-9]{4}$","010-xxxx-xxxx");
    private final String pattern;
    private final String expression;
}
