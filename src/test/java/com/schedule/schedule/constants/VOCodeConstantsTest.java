package com.schedule.schedule.constants;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.schedule.schedule.constants.VOCodeConstants.PHONE_VO_ERROR_CODE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.schedule.schedule.constants
 * fileName       : VOCodeConstantsTest
 * author         : AngryPig123
 * date           : 24. 12. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 21.        AngryPig123       최초 생성
 */
@Slf4j
class VOCodeConstantsTest {

    @Test
    void 값_객체_LOOK_UP_성공() {
        VOCodeConstants result = VOCodeConstants.lookup(PHONE_VO_ERROR_CODE.getMessage());
        Assertions.assertEquals(PHONE_VO_ERROR_CODE, result);
    }

    @Test
    void 값_객체_LOOK_UP_실패() {
        VOCodeConstants result = VOCodeConstants.lookup("실패");
        Assertions.assertNull(result);
    }

}