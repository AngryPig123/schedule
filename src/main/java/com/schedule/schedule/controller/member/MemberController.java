package com.schedule.schedule.controller.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.schedule.schedule.controller.member
 * fileName       : MemberController
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Slf4j
@RestController
public class MemberController {

    @GetMapping
    public String init() {
        log.info("test");
        return "test";
    }

}
