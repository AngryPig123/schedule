package com.schedule.schedule.constants;

import lombok.Getter;

import java.util.Arrays;

import static com.schedule.schedule.constants.ErrorCode.VALUE_OBJECT_ERROR_CODE;

/**
 * packageName    : com.schedule.schedule.constants.exception
 * fileName       : ErrorCode
 * author         : AngryPig123
 * date           : 24. 12. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 21.        AngryPig123       최초 생성
 */
@Getter
public enum VOCodeConstants {

    PHONE_VO_ERROR_CODE("전화번호 형식이 맞지 않습니다."),
    NAME_VO_ERROR_CODE("이름 형식이 맞지 않습니다.");

    private final String message;
    private final int code;

    VOCodeConstants(String message) {
        this.message = message;
        this.code = VALUE_OBJECT_ERROR_CODE;
    }

    public static VOCodeConstants lookup(String message) {
        return Arrays.stream(VOCodeConstants.values())
                .filter(code -> code.getMessage().equals(message))
                .findFirst()
                .orElse(null);
    }

}
