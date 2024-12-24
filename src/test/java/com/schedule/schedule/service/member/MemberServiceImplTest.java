package com.schedule.schedule.service.member;

import com.schedule.schedule.dto.member.MemberInsertRequest;
import com.schedule.schedule.entity.id.MemberLoginId;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Password;
import com.schedule.schedule.vo.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.schedule.schedule.constants.CommonConstants.FALSE_STRING;
import static com.schedule.schedule.constants.CommonConstants.TRUE_STRING;

/**
 * packageName    : com.schedule.schedule.service.member
 * fileName       : MemberServiceImplTest
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Slf4j
@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    void insert() {
        MemberLoginId memberLoginId = MemberLoginId.of("insertTest");
        Password password = Password.of("1q2w3e4r!");
        Password passwordCheck = Password.of("1q2w3e4r!");
        Name name = Name.from("홍", "길동");
        Address homeAddress = Address.from(TRUE_STRING, FALSE_STRING, "142-107", "서울시 강북구 인수봉로 142-12", "2층");
        Phone cellPhone = Phone.from("010", "0000", "0000");
        MemberInsertRequest insertRequest = MemberInsertRequest.from(memberLoginId, password, passwordCheck, name, homeAddress, cellPhone);
        memberService.insertMember(insertRequest);
    }

}