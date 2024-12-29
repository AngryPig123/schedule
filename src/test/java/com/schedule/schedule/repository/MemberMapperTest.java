package com.schedule.schedule.repository;

import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.id.MemberLoginId;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.schedule.schedule.constants.CommonConstants.FALSE_STRING;
import static com.schedule.schedule.constants.CommonConstants.TRUE_STRING;

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
@SpringBootTest
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @Transactional
    void insert() {
        MemberLoginId memberLoginId = MemberLoginId.of("insertTest");
        Optional<Member> memberByLoginId = memberMapper.findMemberByMemberLoginId(memberLoginId);
        Assertions.assertFalse(memberByLoginId.isEmpty());
        Member member = memberByLoginId.get();
        log.info("member = {}", member);
    }

}