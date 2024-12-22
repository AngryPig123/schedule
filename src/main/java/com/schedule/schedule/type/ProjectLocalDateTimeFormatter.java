package com.schedule.schedule.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.schedule.schedule.type
 * fileName       : ProjectLocalDateTimeFormatter
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
public enum ProjectLocalDateTimeFormatter {
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DD_HH_MM_SS_KR("yyyy년 MM월 dd일 HH시 mm분 ss초");
    private final String format;
}
