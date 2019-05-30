package pro.sunhao.service1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sunhao.service1.pojo.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByUserUsername(String username);

    @Modifying
    @Query("update User as user set user.userPassword = ?2 where user.userUsername=?1")
    int updateUserPasswordByUserUsername(String username, String password);

}
