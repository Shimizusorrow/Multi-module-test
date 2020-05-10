package shimizu.identity.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.Student;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Shimizu
 */
@Service
public class StuQueryService {
    @Autowired
    EntityManager entityManager;

    public Student findByName(String name) {
        String sql = "select s from Student s where s.name like " + name;
        return (Student) entityManager.createQuery(sql).getSingleResult();
    }

    public Student findById(String id) {
        return (Student) entityManager.createQuery("select s from Student s where s.Id = "+id).getSingleResult();
    }

    public List<Student>findAll(){
        String sql="select s from Student s ";
        return (List<Student>) entityManager.createQuery(sql).getResultList();
    }

}
