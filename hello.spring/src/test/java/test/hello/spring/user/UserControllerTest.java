package test.hello.spring.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired UserRepository userRepository;
    @Autowired UserService userService;

    @DisplayName("회원 가입")
    @Test
    public void join() {
        // Given
        User user = new User();
        user.setUserName("spring");
        user.setPassword("123");

        // When
        Long saveId = userService.join(user);
        User findUser = userRepository.findOne(saveId);

        // Then
        Assertions.assertThat(user).isEqualTo(findUser);
    }

    @Test
    public void login() {
        // Given


        // When


        // Then

    }

}