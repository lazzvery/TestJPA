package test.hello.spring.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/index";
    }

    @PostMapping("/login")
    public String login(User user) {

        log.info("user={}", user);
        return "/board";

    }

    @GetMapping("/join")
    public String join() {
        return "/join";
    }

    @PostMapping("/join")
    public String join(User user, String password2) {

        log.info("userName={}", user.getUserName());
        log.info("password={}", user.getPassword());
        log.info("password2={}", password2);
        log.info("name={}", user.getName());

        userService.join(user);

        return "/index";

    }

}
