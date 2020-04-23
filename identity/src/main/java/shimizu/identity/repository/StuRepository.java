package shimizu.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shimizu.identity.domain.Student;

public interface StuRepository extends JpaRepository<Student,String> {
    @Query(value = "select s from Student s where s.Id = :id")
    Student findOne(String id);
}
