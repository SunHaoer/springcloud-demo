package pro.sunhao.service1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sunhao.service1.pojo.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    @Modifying
    @Query("update User as user set user.password = ?2 where user.username=?1")
    int updatePasswordByUsername(String username, String password);

}
