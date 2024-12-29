package com.schedule.schedule.config.security;

import com.schedule.schedule.constants.PasswordEncryptType;
import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.MemberDetail;
import com.schedule.schedule.entity.id.MemberLoginId;
import com.schedule.schedule.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.schedule.schedule.util.PasswordEncoderFactory.findPasswordEncoderByPasswordEncryptType;

/**
 * packageName    : com.schedule.schedule.config.security
 * fileName       : BasicAuthenticationProvider
 * author         : AngryPig123
 * date           : 24. 12. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 30.        AngryPig123       최초 생성
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BasicAuthenticationProvider implements AuthenticationProvider {

    private final MemberMapper memberMapper;
    private final MemberDetailsService memberDetailsService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class}, noRollbackFor = BadCredentialsException.class)
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String loginId = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();

        MemberDetails user = (MemberDetails) memberDetailsService.loadUserByUsername(loginId);
        String password = user.getPassword();
        PasswordEncryptType encryptType = user.getEncryptType();
        PasswordEncoder passwordEncoder = findPasswordEncoderByPasswordEncryptType(encryptType);

        if (!passwordEncoder.matches(rawPassword, password)) {
            lockCountUpdate(user.getMember());
            throw new BadCredentialsException("비밀번호가 맞지 않습니다.");
        }

        return new UsernamePasswordAuthenticationToken(
                user,
                rawPassword,
                user.getAuthorities()
        );

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class}, noRollbackFor = BadCredentialsException.class)
    public void lockCountUpdate(Member member) {
        member.increasePasswordLockCount();
        memberMapper.updateMember(member);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
