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
    public String login() { return "/index"; }

    @PostMapping("/login")
    public String login(User user) {
        userService.login(user);
        return "/board";
    }

    @GetMapping("/join")
    public String join() { return "/join"; }

    @PostMapping("/join")
    public String join(User user, String password2) {
        if(user.getPassword() .equals(password2)) userService.join(user);
        else throw new IllegalStateException("비밀번호를 확인해 주세요");
        return "/index";
    }

}
