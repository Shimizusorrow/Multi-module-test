package shimizu.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shimizu.identity.domain.base.User;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/11 15:57
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from User u " +
                    "where u.username = :username")
    User findByUsername(String username);
}
