package com.schedule.schedule.validator.vo;

import com.schedule.schedule.type.ProjectRegex;
import com.schedule.schedule.vo.Phone;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.schedule.schedule.validator.vo
 * fileName       : PhoneValidator
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Slf4j
public class PhoneValidator {

    public static boolean isValidPhoneRegex(Phone phone) {
        String fullNumber = phone.getFirst() + "-" + phone.getMiddle() + "-" + phone.getLast();
        return fullNumber.matches(ProjectRegex.PHONE.getPattern());
    }

}
