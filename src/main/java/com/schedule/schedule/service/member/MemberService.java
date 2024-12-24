package com.schedule.schedule.service.member;

import com.schedule.schedule.dto.member.MemberInsertRequest;
import com.schedule.schedule.entity.Member;

/**
 * packageName    : com.schedule.schedule.service.member
 * fileName       : MemberService
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
public interface MemberService {
    Member insertMember(MemberInsertRequest memberInsertRequest);
}
