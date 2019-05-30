package pro.sunhao.service1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class UserInfo extends User {

    private List<String> userAddress;

    public UserInfo(User user) {
        super(user.getId(), user.getUserUsername(), user.getUserPassword(), user.getUserPhone());
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        final StringBuilder sb = new StringBuilder("{");
        sb.append(superStr.substring(1, superStr.length() - 1)).append(",");
        sb.append("\"userAddress\":")
                .append(userAddress);
        sb.append('}');
        return sb.toString();
    }

}
