package com.schedule.schedule.repository;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.id.LoginId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * packageName    : com.schedule.schedule.repository
 * fileName       : MemberMapper
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Mapper
public interface MemberMapper {

    int insertMember(@Param("member") Member member);

    Optional<Member> findMemberByLoginId(@Param("loginId") LoginId loginId);

}
