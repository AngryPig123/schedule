package com.schedule.schedule.security;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.id.MemberLoginId;
import com.schedule.schedule.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberLoginId memberLoginId = MemberLoginId.of(username);
        Optional<Member> findMember = memberMapper.findMemberByMemberLoginId(memberLoginId);
        Member member = findMember.orElseThrow(() -> new BadCredentialsException(
                "계정을 찾을 수 없습니다."
        ));
        log.info("load user by username = {}", member);
        return MemberDetails.init(member);

    }

}
