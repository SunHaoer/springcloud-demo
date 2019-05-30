package pro.sunhao.service1.pojo;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @GeneratedValue(strategy= GenerationType.AUTO)    // id自增
    @Id
    private Long id;

    @Column(nullable = false, unique = true)    // 非空， 唯一
    private String userUsername;

    @Column(nullable = false)
    private String userPassword;

    @Column
    private String userPhone;

}
