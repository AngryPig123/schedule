package com.schedule.schedule.entity;

import com.schedule.schedule.entity.id.LoginId;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Password;
import com.schedule.schedule.vo.Phone;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.schedule.schedule.entity
 * fileName       : Member
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Alias("Member")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends CommonEntity {

    private Long id;
    private LoginId loginId;
    private Password password;
    private Name name;
    private Address homeAddress;
    private Phone cellPhone;

    private Member(LoginId loginId, Password password, Name name, Address homeAddress, Phone cellPhone) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.homeAddress = homeAddress;
        this.cellPhone = cellPhone;
    }

    public static Member init(LoginId loginId, Password password, Name name, Address homeAddress, Phone cellPhone) {
        return new Member(loginId, password, name, homeAddress, cellPhone);
    }


}
