package test.hello.spring.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Id @Column(name = "user_id", length = 11, nullable = false)
    private Long id;

    private String password;
    private int age;
    private String phone;

}
