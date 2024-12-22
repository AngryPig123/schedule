package com.schedule.schedule.validator.entity;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.exception.vo.ValueObjectException;

import static com.schedule.schedule.constants.VOCodeConstants.NAME_VO_ERROR_CODE;
import static com.schedule.schedule.constants.VOCodeConstants.PHONE_VO_ERROR_CODE;
import static com.schedule.schedule.validator.vo.VOValidator.*;

/**
 * packageName    : com.schedule.schedule.validator.entity
 * fileName       : MemberValodator
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
public class MemberValidator {

    public static void valid(Member member) {
        boolean nameValid = isValidNameRegex(member.getName());
        if (!nameValid) throw ValueObjectException.of(NAME_VO_ERROR_CODE);
        boolean homePhoneValid = isValidPhoneRegex(member.getCellPhone());
        if (!homePhoneValid) throw ValueObjectException.of(PHONE_VO_ERROR_CODE);
        validateAddress(member.getHomeAddress());
    }

}
