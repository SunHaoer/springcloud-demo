package pro.sunhao.service1.pojo;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userUsername\":\"")
                .append(userUsername).append('\"');
        sb.append(",\"userPassword\":\"")
                .append(userPassword).append('\"');
        sb.append(",\"userPhone\":\"")
                .append(userPhone).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
