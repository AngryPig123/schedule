package com.schedule.schedule.dto.member;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.id.MemberLoginId;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Password;
import com.schedule.schedule.vo.Phone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * packageName    : com.schedule.schedule.dto.member
 * fileName       : MemberInsertRequest
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Getter
@ToString
@EqualsAndHashCode
public class MemberInsertRequest {

    private final MemberLoginId memberLoginId;
    private final Password password;
    private final Password passwordCheck;
    private final Name name;
    private final Address homeAddress;
    private final Phone cellPhone;

    private MemberInsertRequest(MemberLoginId memberLoginId, Password password, Password passwordCheck, Name name, Address homeAddress, Phone cellPhone) {
        this.memberLoginId = memberLoginId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.homeAddress = homeAddress;
        this.cellPhone = cellPhone;
    }

    public static MemberInsertRequest from(MemberLoginId memberLoginId, Password password, Password passwordCheck, Name name, Address homeAddress, Phone cellPhone) {
        return new MemberInsertRequest(memberLoginId, password, passwordCheck, name, homeAddress, cellPhone);
    }

    public Member toEntity() {
        return Member.init(this.memberLoginId, this.password, this.name, this.homeAddress, this.cellPhone);
    }

}
