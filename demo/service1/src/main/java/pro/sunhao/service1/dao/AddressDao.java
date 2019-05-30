package pro.sunhao.service1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pro.sunhao.service1.pojo.Address;

import java.util.List;

public interface AddressDao extends JpaRepository<Address, Long> {

    @Modifying
    @Query("select address.userAddress from Address address where address.userId = ?1")
    List<String> findAddressByUserId(Long userId);

}
