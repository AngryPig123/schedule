package com.schedule.schedule.vo;

import com.schedule.schedule.exception.vo.ValueObjectException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.schedule.schedule.constants.VOCodeConstants.PHONE_VO_ERROR_CODE;

/**
 * packageName    : com.schedule.schedule.vo
 * fileName       : PhoneTest
 * author         : AngryPig123
 * date           : 24. 12. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 21.        AngryPig123       최초 생성
 */
@Slf4j
class PhoneTest {

    @Test
    void 핸드폰_객체_생성_성공() {
        Assertions.assertDoesNotThrow(() -> {
            Phone.from("010", "0000", "0000");
        });
    }

    @Test
    void 핸드폰_객체_생성_실패() {
        ValueObjectException voException = Assertions.assertThrows(ValueObjectException.class, () -> {
            Phone.from("011", "0000", "0000");
        });
        Assertions.assertEquals(PHONE_VO_ERROR_CODE.getMessage(), voException.getMessage());
    }

}