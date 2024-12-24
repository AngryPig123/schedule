package com.schedule.schedule.util;

import com.schedule.schedule.constants.PasswordEncryptType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * packageName    : com.schedule.schedule.util
 * fileName       : PasswordEncoderFactory
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Slf4j
public class PasswordEncoderFactory {

    private static final PasswordEncoder BCRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private static final PasswordEncoder SCRYPT_PASSWORD_ENCODER = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
    private static final PasswordEncoder NOOP_ENCODER = NoOpPasswordEncoder.getInstance();
    private static final PasswordEncoder TWO_WAY_PASSWORD_ENCODER = new TwoWayPasswordEncoder();

    public static PasswordEncoder findPasswordEncoderByPasswordEncryptType(PasswordEncryptType passwordEncryptType) {
        return switch (passwordEncryptType) {
            case BCRYPT -> BCRYPT_PASSWORD_ENCODER;
            case SCRYPT -> SCRYPT_PASSWORD_ENCODER;
            case NOOP -> NOOP_ENCODER;
            case TWO_WAY -> TWO_WAY_PASSWORD_ENCODER;
            default -> throw new IllegalArgumentException("Unsupported encryption type: " + passwordEncryptType);
        };
    }

}
