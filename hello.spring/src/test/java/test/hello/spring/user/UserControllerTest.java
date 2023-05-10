package test.hello.spring.user;

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

    @Test
    public void join() {
        // Given
        User user = new User();
        user.setUserName("spring");

        // When
        Long saveId = userService.join(user);

        // Then
        User findUser = userRepository.findOne(saveId);
        assertEquals(user, findUser);

    }

}