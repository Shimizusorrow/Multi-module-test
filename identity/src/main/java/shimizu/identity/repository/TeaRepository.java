package shimizu.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shimizu.identity.domain.Teacher;

/**
 * @author Shimizu
 */
public interface TeaRepository extends JpaRepository<Teacher,String> {

}
