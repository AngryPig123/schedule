package com.schedule.schedule.validator.entity;

import com.schedule.schedule.entity.Member;

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

    public static void validate(Member member) {
        isValidNameRegex(member.getName());
        isValidPhoneRegex(member.getCellPhone());
        validAddress(member.getHomeAddress());
    }

}
