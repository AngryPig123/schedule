package com.schedule.schedule.validator.vo;

import com.schedule.schedule.exception.vo.ValueObjectException;
import com.schedule.schedule.type.ProjectRegex;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Phone;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.util.StringUtils;

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

    public static boolean isValidPhoneRegex(Phone vo) {
        String fullNumber = vo.getFirstNumber() + "-" + vo.getMiddleNumber() + "-" + vo.getLastNumber();
        return fullNumber.matches(ProjectRegex.PHONE.getPattern());
    }

    public static boolean isValidNameRegex(Name vo) {
        String fullName = vo.getFirstName() + vo.getLastName();
        return fullName.matches(ProjectRegex.NAME.getPattern());
    }

    public static void validateAddress(Address vo) {

        String doro = vo.getDoroAddress();
        String jiBun = vo.getJiBunAddress();
        String zipCode = vo.getZipCode();
        String address = vo.getAddress();
        String addressDetail = vo.getAddressDetail();

        if (doro.equals(jiBun)) throw ValueObjectException.of("도로명 주소와 지번 주소는 하나만 선택 가능합니다.");

        if (!isNullOrEmpty(zipCode, address, addressDetail))
            throw ValueObjectException.of("우편번호, 주소, 상세 주소는 모두 필수 값입니다.");

    }

    private static boolean isNullOrEmpty(String... values) {
        for (String value : values) {
            if (!StringUtils.isEmpty(value)) {
                return true;
            }
        }
        return false;
    }

}
