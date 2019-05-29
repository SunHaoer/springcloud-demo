package pro.sunhao.service1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sunhao.service1.pojo.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
