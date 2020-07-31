package shimizu.common.basedomain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/29 16:31
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * 通过账号查找用户
     *
     * @param accountNumber
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from User u where u.account_number = :accountNumber")
    User findByAccountNumber(String accountNumber);
}
