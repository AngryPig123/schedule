package com.schedule.schedule.vo;

import com.schedule.schedule.constants.PasswordEncryptType;
import com.schedule.schedule.util.TwoWayPasswordEncoder;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.schedule.schedule.constants.CommonConstants.PASSWORD_LOCK_COUNT;
import static com.schedule.schedule.util.CommonUtil.getPasswordEncoder;
import static com.schedule.schedule.validator.vo.VOValidator.validPassword;

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
@Alias("Password")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Password {

    private PasswordEncryptType encryptType;
    private String password;
    private int lockCount;

    private Password(String password) {
        this.encryptType = PasswordEncryptType.BCRYPT;
        this.password = password;
        this.lockCount = 0;
    }

    private Password(String password, int lockCount) {
        this.encryptType = PasswordEncryptType.BCRYPT;
        this.password = password;
        this.lockCount = lockCount;
    }
    
    public static Password of(String password) {
        Password vo = new Password(password);
        validPassword(vo);
        return vo;
    }

    public static Password from(String password, int lockCount) {
        Password vo = new Password(password, lockCount);
        validPassword(vo);
        return vo;
    }

    public boolean matched(String rawPassword) {
        PasswordEncoder encoder = getPasswordEncoder(this.encryptType);
        return encoder.matches(rawPassword, this.password);
    }

    public Password encrypt() {
        PasswordEncoder passwordEncoder = getPasswordEncoder(this.encryptType);
        return Password.of(passwordEncoder.encode(this.password));
    }

    public String decrypt() {
        PasswordEncoder passwordEncoder = getPasswordEncoder(this.encryptType);
        if (passwordEncoder instanceof TwoWayPasswordEncoder) {
            TwoWayPasswordEncoder twoWayPasswordEncoder = (TwoWayPasswordEncoder) getPasswordEncoder(this.encryptType);
            return twoWayPasswordEncoder.decrypt(this.password);
        }
        throw new RuntimeException("복호화가 불가능한 엔코더 형식 입니다.");
    }

    public Password increasePasswordLockCount() {
        int lockCount = this.lockCount;
        if (lockCount < PASSWORD_LOCK_COUNT) {
            return Password.from(this.password, ++lockCount);
        } else {
            return this;
        }
    }

}
