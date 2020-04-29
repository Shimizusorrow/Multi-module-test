package shimizu.identity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.Student;
import shimizu.identity.repository.StuRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class StuService {
    @Autowired
    private StuRepository stuRepository;

    @Autowired
    private EntityManager entityManager;

//    public Page<Student> student(PageRequest pageRequest) {
//        Query query = entityManager.createQuery("select s from  Student s");
//        query.setMaxResults(pageRequest.getPageSize());
//        query.setFirstResult(pageRequest.getPageNumber()-1);
//        query.getResultList();
//
//    }

}
