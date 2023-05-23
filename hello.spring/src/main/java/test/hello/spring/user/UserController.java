package test.hello.spring.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
        userService.login(user);
        return "/board";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "/join";
    }

    @PostMapping("/join")
    public String join(@Valid UserForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "/join";
        }

        if (form.getPassword().equals(form.getPassword2())) {
            User user = User.builder()
                    .userName(form.getUserName())
                    .password(form.getPassword())
                    .name(form.getName())
                    .build();

            userService.join(user);
        } else {
            throw new IllegalStateException("비밀번호를 확인해 주세요");
        }

        return "redirect:/";

    }

}
