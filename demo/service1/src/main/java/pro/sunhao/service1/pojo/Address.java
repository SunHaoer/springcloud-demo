package pro.sunhao.service1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    @GeneratedValue(strategy= GenerationType.AUTO)    // id自增
    @Id
    private Long id;

    @Column
    private Long userId;

    @Column
    private String userAddress;

}
