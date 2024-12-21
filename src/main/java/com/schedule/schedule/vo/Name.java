package com.schedule.schedule.vo;

import com.schedule.schedule.exception.vo.ValueObjectException;
import lombok.*;
import org.apache.ibatis.type.Alias;

import static com.schedule.schedule.constants.VOCodeConstants.NAME_VO_ERROR_CODE;
import static com.schedule.schedule.validator.vo.VOValidator.isValidNameRegex;

/**
 * packageName    : com.schedule.schedule.vo
 * fileName       : Name
 * author         : AngryPig123
 * date           : 24. 12. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 21.        AngryPig123       최초 생성
 */
@Alias("Name")
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Name {

    private final String firstName;
    private final String lastName;

    public static Name from(String first, String last) {
        Name name = new Name(first, last);
        boolean valid = isValidNameRegex(name);
        if (!valid) throw ValueObjectException.of(NAME_VO_ERROR_CODE);
        return name;
    }

    public String fullName() {
        return String.format("%s%s", this.firstName, this.lastName);
    }

}
