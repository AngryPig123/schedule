package com.schedule.schedule.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
@Getter
@AllArgsConstructor
public enum PasswordEncryptType {
    BCRYPT, NOOP, SCRYPT, TWO_WAY
}
