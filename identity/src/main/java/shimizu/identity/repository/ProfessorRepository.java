package shimizu.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shimizu.identity.domain.Professor;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/20 11:56
 */
public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
