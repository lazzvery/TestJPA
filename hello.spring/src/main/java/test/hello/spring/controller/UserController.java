package test.hello.spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserController {

    @PostMapping
    public String loginId(String id, String password) {
        log.info("id={}", id);
        log.info("password={}", password);
        return "hello";
    }

}
