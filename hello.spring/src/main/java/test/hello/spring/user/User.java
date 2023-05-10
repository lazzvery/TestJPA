package test.hello.spring.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", length = 11, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String userName;

    private String password;
    private String name;

}
