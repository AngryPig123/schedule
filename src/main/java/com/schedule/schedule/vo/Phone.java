package com.schedule.schedule.vo;

import lombok.*;
import org.apache.ibatis.type.Alias;

import static com.schedule.schedule.validator.vo.VOValidator.isValidPhoneRegex;

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
@Alias("Phone")
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Phone {

    private final String firstNumber;
    private final String middleNumber;
    private final String lastNumber;

    public static Phone from(String first, String middle, String last) {
        Phone phone = new Phone(first, middle, last);
        isValidPhoneRegex(phone);
        return phone;
    }

    public String fullNumber() {
        return String.format("%s-%s-%s", this.firstNumber, this.middleNumber, this.lastNumber);
    }

}
