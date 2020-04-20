package shimizu.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shimizu.identity.domain.Student;

public interface StuRepository extends JpaRepository<Student,String> {
}
