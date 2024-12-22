package com.schedule.schedule.exception.vo;

import com.schedule.schedule.constants.VOCodeConstants;
import com.schedule.schedule.exception.CommonException;
import lombok.Getter;

import static com.schedule.schedule.constants.ErrorCode.VALUE_OBJECT_ERROR_CODE;

/**
 * packageName    : com.schedule.schedule.exception.vo
 * fileName       : ValueObjectException
 * author         : AngryPig123
 * date           : 24. 12. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 21.        AngryPig123       최초 생성
 */
@Getter
public class ValueObjectException extends CommonException {

    private ValueObjectException(String message) {
        super(message, VALUE_OBJECT_ERROR_CODE);
    }

    private ValueObjectException(VOCodeConstants VOCodeConstants) {
        super(VOCodeConstants.getMessage(), VOCodeConstants.getCode());
    }

    public static ValueObjectException of(VOCodeConstants VOCodeConstants) {
        return new ValueObjectException(VOCodeConstants);
    }

    public static ValueObjectException of(String message) {
        return new ValueObjectException(message);
    }

}
