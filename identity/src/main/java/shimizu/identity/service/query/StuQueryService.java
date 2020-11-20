package shimizu.identity.service.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.Student;
import shimizu.identity.repository.StuRepository;
import shimizu.identity.utils.QueryMapperUtil;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Shimizu
 */
@Service
@AllArgsConstructor
public class StuQueryService {

    @Autowired
    private EntityManager entityManager;


    private final StuRepository stuRepository;

    private final static Set<String> SET = new HashSet<>();

    public Student findByName(String name) {
        String sql = "select s from Student s where s.name like " + name;
        return (Student) entityManager.createQuery(sql).getSingleResult();
    }

    public Student findById(String id) {
        return (Student) entityManager.createQuery("select s from Student s where s.id = " + id).getSingleResult();
    }

    public List<Student> findAll() {
        String sql = "select s from Student s ";
        return (List<Student>) entityManager.createQuery(sql).getResultList();
    }


    public List<Student> findTest() {
        final String sql = "select * from student s where s.id is not null ";
        return (List<Student>) entityManager.createNativeQuery(sql).getResultList();
    }

    public List<Student> findBySchool(String stuNumber, String shoNumber) {
        QueryMapperUtil queryMapperUtil = QueryMapperUtil.getQueryMapper(entityManager);
        Map<String, String> con = new HashMap<>();
        con.put("stuNumber", "and s.stu_number = :stuNumber");
        con.put("shoNumber", "and s.sho_number like :shoNumber");
        Map<String, Object> par = new HashMap<>();
        if (stuNumber != null) {
            par.put("stuNumber", stuNumber);
        }
        if (shoNumber != null) {
            par.put("shoNumber", shoNumber);
        }
        return (List<Student>) queryMapperUtil
                .createHeadSql("select * from student s where s.id is not null")
                .addParams(par)
                .addCondition(con)
                .getResult();
    }

    public List<Student> findByNameOrGender(String name, String gender) {
        QueryMapperUtil queryMapperUtil = QueryMapperUtil.getQueryMapper(entityManager);
        Map<String, String> con = new HashMap<>();
        con.put("gender", "and s.gender = :gender");
        con.put("name", "and s.name like :name");
        Map<String, Object> par = new HashMap<>();
        if (name != null) {
            par.put("name", name);
        }
        if (gender != null) {
            par.put("gender", gender);
        }
        return (List<Student>) queryMapperUtil
                .createHeadSql("select * from student s where s.id is not null")
                .addParams(par)
                .addCondition(con)
                .getResult();
    }

    public Page<Student> findByNameAndShoNumberAndGender(String name, String number, String gender, Pageable pageable) {
        return stuRepository.findByNameAndShoNumberAndGender(name, number, gender, pageable);
    }

    /**
     * 使用4个线程去创建学生
     */
    public void initStudent() {
        long time = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(8);
        Task task = new Task(stuRepository);
        for (int i = 0; i < 20000; i++) {
            final String g = i + "";
            task.id = g;
            es.submit(task);
        }
        // 关闭线程池:
        es.shutdown();
        while (!es.isTerminated()) {

        }
        System.out.println(String.format("耗时: %d 秒", (System.currentTimeMillis() - time) / 1000));
    }

    @Data
    private static class Task implements Runnable {
        private String id;
        private StuRepository stuRepository;

        public Task(String id) {
            this.id = id;
        }

        public Task(StuRepository stuRepository) {
            this.stuRepository = stuRepository;
        }

        @Override
        public void run() {
            stuRepository.save(new Student(id,
                    generateNoRepeatString(),
                    4,
                    generateNoRepeatString(),
                    generateNoRepeatString(),
                    3,
                    generateNoRepeatString()));
        }
    }

    private static String generateNoRepeatString() {
        String temp = getString();
        while (SET.contains(temp)) {
            temp = getString();
        }
        SET.add(temp);
        return temp;
    }

    private static String getString() {
        return String.format("%06x", (int) (Math.random() * 999999));
    }


}
