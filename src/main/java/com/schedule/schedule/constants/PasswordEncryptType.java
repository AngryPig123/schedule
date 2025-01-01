package com.schedule.schedule.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.util.Arrays;

/**
 * packageName    : com.schedule.schedule.constants
 * fileName       : PasswordEncryptType
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Alias("PasswordEncryptType")
@Getter
@AllArgsConstructor
public enum PasswordEncryptType {
    BCRYPT, NOOP, SCRYPT, TWO_WAY;

    public static PasswordEncryptType lookup(String type) {
        return Arrays.stream(PasswordEncryptType.values())
                .filter(code -> code.name().equals(type))
                .findFirst()
                .orElse(null);
    }

}
