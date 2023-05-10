package test.hello.spring.category;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id", length = 11, nullable = false)
    private Long id;

    private String name;

}
