package com.schedule.schedule.service.member;

import com.schedule.schedule.dto.member.MemberInsertRequest;
import com.schedule.schedule.entity.Member;
import com.schedule.schedule.repository.MemberDetailMapper;
import com.schedule.schedule.repository.MemberMapper;
import com.schedule.schedule.vo.Password;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.schedule.schedule.validator.vo.VOValidator.validPassword;

/**
 * packageName    : com.schedule.schedule.service.member
 * fileName       : MemberServiceImpl
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Slf4j
@Service
@ToString
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final MemberDetailMapper memberDetailMapper;

    @Override
    public Member insertMember(MemberInsertRequest memberInsertRequest) {
        this.insertMemberRequestValid(memberInsertRequest);
        Member memberEntity = memberInsertRequest.toEntity();
        memberEntity.valid();
        boolean exists = memberMapper.findMemberByMemberLoginId(memberEntity.getMemberLoginId()).isPresent();
        if (exists) throw new RuntimeException("이미 존재하는 계정입니다.");
        int result = memberMapper.insertMember(memberEntity);
        if (result < 1) throw new RuntimeException("계정 생성중 에러가 발생하였습니다.");
        return memberEntity;
    }

    private void insertMemberRequestValid(MemberInsertRequest memberInsertRequest) {
        if (Objects.isNull(memberInsertRequest)) throw new RuntimeException();
        Password password = memberInsertRequest.getPassword();
        Password passwordCheck = memberInsertRequest.getPasswordCheck();
        if (!password.equals(passwordCheck)) throw new RuntimeException("비밀번호가 맞지 않습니다.");
        validPassword(password);
        validPassword(passwordCheck);
    }

}
