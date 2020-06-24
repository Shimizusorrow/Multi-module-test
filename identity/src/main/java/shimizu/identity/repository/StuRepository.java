package shimizu.identity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shimizu.identity.domain.Student;

/**
 * @author Shimizu
 */
public interface StuRepository extends JpaRepository<Student, String> {
    @Query(value = "select s from Student s where s.Id = :id")
    Student findOne(String id);

//    @Query(value = "select s from Student as s where ")
//    Page<Student>pages(Pageable pageable);
}
