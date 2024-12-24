package com.schedule.schedule.vo;

import lombok.*;
import org.apache.ibatis.type.Alias;

import static com.schedule.schedule.validator.vo.VOValidator.validAddress;

/**
 * packageName    : com.schedule.schedule.vo
 * fileName       : Address
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Alias("Address")
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    private final String doroYn;
    private final String jiBunYn;
    private final String zipCode;
    private final String address;
    private final String addressDetail;

    public static Address from(String doroAddress, String jiBunAddress, String zipCode, String address, String addressDetail) {
        Address vo = new Address(doroAddress, jiBunAddress, zipCode, address, addressDetail);
        validAddress(vo);
        return vo;
    }

}
