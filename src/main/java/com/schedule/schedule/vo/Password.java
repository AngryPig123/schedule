package com.schedule.schedule.vo;

import com.schedule.schedule.constants.PasswordEncryptType;
import com.schedule.schedule.util.TwoWayPasswordEncoder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.schedule.schedule.util.CommonUtil.getPasswordEncoder;

/**
 * packageName    : com.schedule.schedule.vo
 * fileName       : Password
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Getter
@EqualsAndHashCode
public class Password {

    private final PasswordEncryptType passwordEncryptType;
    private final String password;

    private Password(String password) {
        this.passwordEncryptType = PasswordEncryptType.BCRYPT;
        this.password = password;
    }

    public static Password of(String password) {
        return new Password(password);
    }

    public boolean matched(String rawPassword) {
        PasswordEncoder encoder = getPasswordEncoder(this.passwordEncryptType);
        return encoder.matches(rawPassword, this.password);
    }

    public String decrypt() {
        PasswordEncoder passwordEncoder = getPasswordEncoder(this.passwordEncryptType);
        if (passwordEncoder instanceof TwoWayPasswordEncoder) {
            TwoWayPasswordEncoder twoWayPasswordEncoder = (TwoWayPasswordEncoder) getPasswordEncoder(this.passwordEncryptType);
            return twoWayPasswordEncoder.decrypt(this.password);
        }
        throw new RuntimeException("");
    }

}
