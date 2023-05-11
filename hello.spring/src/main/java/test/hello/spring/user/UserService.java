package test.hello.spring.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);    // 중복 회원 검증
        encodePassword(user);   // 패스워드 암호화
        userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public boolean login(User user) {
        Optional<User> findUser = userRepository.findByName(user.getUserName()).stream().findFirst();
        String encodedPassword = findUser.map(User::getPassword).orElseThrow(() -> new IllegalStateException("아이디와 비밀번호를 확인해 주세요"));

        if(encoder.matches(user.getPassword(), encodedPassword)) {
            return true;
        } else {
            throw new IllegalStateException("아이디와 비밀번호를 확인해 주세요");
        }
    }

    private void encodePassword(User user) {
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
    }

    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByName(user.getUserName());
        if(!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

}
