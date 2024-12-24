package com.schedule.schedule.validator.vo;

import com.schedule.schedule.exception.vo.ValueObjectException;
import com.schedule.schedule.type.ProjectRegex;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Password;
import com.schedule.schedule.vo.Phone;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * packageName    : com.schedule.schedule.validator.vo
 * fileName       : PhoneValidator
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Slf4j
public class VOValidator {

    public static void isValidPhoneRegex(Phone vo) {
        String fullNumber = vo.getFirstNumber() + "-" + vo.getMiddleNumber() + "-" + vo.getLastNumber();
        boolean valid = fullNumber.matches(ProjectRegex.PHONE.getPattern());
        if (!valid) {
            throw ValueObjectException.of("전화번호를 다시 확인해 주세요..");
        }
    }

    public static void isValidNameRegex(Name vo) {
        String fullName = vo.getFirstName() + vo.getLastName();
        boolean valid = fullName.matches(ProjectRegex.NAME.getPattern());
        if (!valid) {
            throw ValueObjectException.of("이름을 다시 확인해 주세요.");
        }
    }

    public static void validAddress(Address vo) {

        String doro = vo.getDoroYn();
        String jiBun = vo.getJiBunYn();
        String zipCode = vo.getZipCode();
        String address = vo.getAddress();
        String addressDetail = vo.getAddressDetail();

        if (doro.equals(jiBun)) {
            throw ValueObjectException.of("도로명 주소와 지번 주소는 하나만 선택 가능합니다.");
        }

        if (isNullOrEmpty(zipCode, address, addressDetail)) {
            throw ValueObjectException.of("우편번호, 주소, 상세 주소는 모두 필수 값입니다.");
        }

    }

    public static void validPassword(Password password) {
        if (isNullOrEmpty(password.getPassword(), password))
            throw ValueObjectException.of("비밀번호를 다시 확인해 주세요");
    }

    private static boolean isNullOrEmpty(Object... values) {
        for (Object value : values) {
            return Objects.isNull(value);
        }
        return false;
    }

}
