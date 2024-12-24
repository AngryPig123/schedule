package com.schedule.schedule.constants;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.schedule.schedule.constants
 * fileName       : PasswordEncryptTypeTest
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Slf4j
class PasswordEncryptTypeTest {

    @Test
    void BCRYPT_찾기_테스트() {
        PasswordEncryptType encoder = PasswordEncryptType.lookup("BCRYPT");
        Assertions.assertEquals(PasswordEncryptType.BCRYPT, encoder);
    }

}