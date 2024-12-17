package com.schedule.schedule.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.schedule.schedule.validator.vo.PhoneValidator.isValidPhoneRegex;

/**
 * packageName    : com.schedule.schedule.vo
 * fileName       : Phone
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Phone {

    private final String first;
    private final String middle;
    private final String last;

    public static Phone from(String first, String middle, String last) {
        return new Phone(first, middle, last);
    }

    public String fullNumber() {
        if (isValidPhoneRegex(this)) {
            return String.format("%s-%s-%s", this.first, this.middle, this.last);
        } else {
            throw new RuntimeException();
        }
    }

}
