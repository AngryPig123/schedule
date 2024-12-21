package com.schedule.schedule.vo;

import lombok.*;

import static com.schedule.schedule.validator.vo.VOValidator.validateAddress;

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
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    private final boolean doroAddress;
    private final boolean jiBunAddress;
    private final String zipCode;
    private final String address;
    private final String addressDetail;

    public static Address from(boolean doroAddress, boolean jiBunAddress, String zipCode, String address, String addressDetail) {
        Address vo = new Address(doroAddress, jiBunAddress, zipCode, address, addressDetail);
        validateAddress(vo);
        return vo;
    }

}
