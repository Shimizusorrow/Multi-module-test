package shimizu.identity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import shimizu.identity.domain.Student;

import java.util.List;

/**
 * @author Shimizu
 */
public interface StuRepository extends JpaRepository<Student, String> {
    @Query(value = "select s from Student s where s.id = :id")
    Student findOne(String id);

    /**
     * 测试readOnly
     * @return
     */
    @Transactional(readOnly = true)
    @Query(nativeQuery = true,
            value = "select  * from student s  ")
    List<Student> findAllReadOnly();

//    @Query(value = "select s from Student as s where ")
//    Page<Student>pages(Pageable pageable);

    /**
     * 测试多条件分页查询
     *
     * @param name
     * @param number
     * @param gender
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from student s " +
                    "where (:name is null or s.name like %:name% )" +
                    "and (:gender is null or s.gender = :gender) " +
                    "and (:number is null or s.sho_number = :number)",
            countQuery = "select count(*) from student s " +
                    "where (:name is null or s.name like %:name%) " +
                    "and (:gender is null or s.gender = :gender) " +
                    "and (:number is null or s.sho_number = :number)")
    Page<Student> findByNameAndShoNumberAndGender(String name, String number, String gender, Pageable pageable);
}
