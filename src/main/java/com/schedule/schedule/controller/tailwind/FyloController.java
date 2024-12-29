package com.schedule.schedule.controller.tailwind;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.schedule.schedule.controller.tailwind
 * fileName       : FyloController
 * author         : AngryPig123
 * date           : 24. 12. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 29.        AngryPig123       최초 생성
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/fylo")
public class FyloController {

    @GetMapping
    public String index() {
        return "fylo/index";
    }

}
