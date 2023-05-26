package test.hello.spring.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class UserForm {

    @NotEmpty(message = "아이디를 입력해 주세요")
    private String userName;

    private String password;
    private String password2;
    private String name;

}
