package com.schedule.schedule.repository;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.id.LoginId;
import com.schedule.schedule.validator.entity.MemberValidator;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Password;
import com.schedule.schedule.vo.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.schedule.schedule.constants.CommonConstants.FALSE_STRING;
import static com.schedule.schedule.constants.CommonConstants.TRUE_STRING;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.schedule.schedule.repository
 * fileName       : MemberMapperTest
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Slf4j
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @Transactional
    void insert() {
        LoginId loginId = LoginId.of("insertTest");
        Password password = Password.of("1q2w3e4r!");
        Name name = Name.from("홍", "길동");
        Address homeAddress = Address.from(TRUE_STRING, FALSE_STRING, "142-107", "서울시 강북구 인수봉로 142-12", "2층");
        Phone cellPhone = Phone.from("010", "0000", "0000");
        Member init = Member.init(loginId, password, name, homeAddress, cellPhone);
        MemberValidator.valid(init);
        memberMapper.insertMember(init);

        Optional<Member> memberByLoginId = memberMapper.findMemberByLoginId(init.getLoginId());
        Assertions.assertFalse(memberByLoginId.isEmpty());
        Member member = memberByLoginId.get();
        log.info("member = {}", member);
    }

}