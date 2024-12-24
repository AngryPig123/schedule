package com.schedule.schedule.exception;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.schedule.schedule.exception
 * fileName       : CommonException
 * author         : AngryPig123
 * date           : 24. 12. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 21.        AngryPig123       최초 생성
 */
@Getter
public class CommonException extends RuntimeException {

    protected int code;
    protected LocalDateTime timeStamp;

    protected CommonException() {

    }

    protected CommonException(int code) {
        super();
        this.code = code;
        this.timeStamp = LocalDateTime.now();
    }

    protected CommonException(String message, int code) {
        super(message);
        this.code = code;
        this.timeStamp = LocalDateTime.now();
    }

    public static CommonException from(String message, int code) {
        return new CommonException(message, code);
    }

}
