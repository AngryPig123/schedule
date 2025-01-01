package com.schedule.schedule.config.security;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.MemberDetail;
import com.schedule.schedule.entity.id.MemberLoginId;
import com.schedule.schedule.repository.MemberDetailMapper;
import com.schedule.schedule.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * packageName    : com.schedule.schedule.security
 * fileName       : MemberDatailsService
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final MemberDetailMapper memberDetailMapper;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        MemberLoginId memberLoginId = MemberLoginId.of(loginId);

        Optional<Member> findMember = memberMapper.findMemberByMemberLoginId(memberLoginId);
        Member member = findMember.orElseThrow(() -> new BadCredentialsException(
                "계정을 찾을 수 없습니다."
        ));
        log.info("load user by loginId = {}", member);

        Optional<MemberDetail> findMemberDetail = memberDetailMapper.findMemberDetailByMemberId(member.getMemberId());
        return MemberDetails.init(member, findMemberDetail.orElse(null));

    }

}
