package pro.sunhao.service1.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {

    @GeneratedValue    // id自增
    @Id
    private Long id;

    @Column    // 非空， 唯一
    private String username;

    @Column
    private String password;

    @Column
    private String tel;

}
