package com.schedule.schedule.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.schedule.schedule.security
 * fileName       : UsernamePasswordAuthenticationProvider
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Slf4j
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String memberId = authentication.getName();
        String password = authentication.getCredentials().toString();

        return null;

    }


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
    public void passwordUpdate() {

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationProvider.class.isAssignableFrom(authentication);
    }

}
