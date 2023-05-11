package test.hello.spring.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findByName(String userName) {
        return em.createQuery("select u from User u where u.userName = :userName", User.class)
                .setParameter("userName", userName)
                .getResultList();
    }

}
