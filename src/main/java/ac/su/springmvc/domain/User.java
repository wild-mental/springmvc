package ac.su.springmvc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    //1) DB 변경 후, 아래와 같은 컬럼이 비즈니스 로직상으로는 필요하지만
    //   불필요하게 모든 응답에 표현되는 것을 막고 싶음
    //   -> DTO 사용으로 해결!
    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double height;
}