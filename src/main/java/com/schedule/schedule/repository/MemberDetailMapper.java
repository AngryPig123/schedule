package com.schedule.schedule.repository;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.MemberDetail;
import com.schedule.schedule.entity.id.MemberLoginId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * packageName    : com.schedule.schedule.repository
 * fileName       : MemberDetailMapper
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Mapper
public interface MemberDetailMapper {

    int insertMemberDetail(@Param("memberDetail") MemberDetail memberDetail);

    Optional<MemberDetail> findMemberDetailByMemberId(@Param("memberId") String memberId);

}
