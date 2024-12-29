package com.schedule.schedule;

import com.schedule.schedule.dto.member.MemberInsertRequest;
import com.schedule.schedule.entity.id.MemberLoginId;
import com.schedule.schedule.service.member.MemberService;
import com.schedule.schedule.vo.Address;
import com.schedule.schedule.vo.Name;
import com.schedule.schedule.vo.Password;
import com.schedule.schedule.vo.Phone;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LogLevel;

import static com.schedule.schedule.constants.CommonConstants.FALSE_STRING;
import static com.schedule.schedule.constants.CommonConstants.TRUE_STRING;
import static com.schedule.schedule.util.CommonUtil.logging;


@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ScheduleApplication {

    private final MemberService memberService;

    @Value("${server.host:8080}")
    private Integer SERVER_HOST;

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

    @PostConstruct
    public void init() {
        logging(LogLevel.INFO,
                "server properties start",
                "server host = %s".formatted(SERVER_HOST),
                "server properties end"
        );

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
