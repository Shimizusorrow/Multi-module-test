package shimizu.identity.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/1 11:00
 */
@DataJpaTest
//@Import(EntityManager.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
class QueryMapperUtilTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    public void assertNotNulls() {
        assertNotNull(entityManager);
    }

    @Test
    void test() {
        QueryMapperUtil queryMapperUtil = QueryMapperUtil.getQueryMapper(entityManager);
        Map<String, String> condition = new HashMap<>();
        condition.put("name", "and s.name like :name");
        condition.put("gender", "and s.gender = :gender");
        Map<String, Object> params = new HashMap<>();
        params.put("name", "1");
//        params.put("gender", 2);
        String s = queryMapperUtil.createHeadSql("select * from student s where s.id is not null")
                .addParams(params)
                .addCondition(condition)
                .toSqlString();

        System.out.println(s);


    }

//    @BeforeEach
//    void beforeEach() {
//        QueryMapperUtil queryMapperUtil = QueryMapperUtil.getQueryMapper(entityManager);
//
//    }

    @Test
    void test1() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    QueryMapperUtil queryMapperUtil = QueryMapperUtil.getQueryMapper();
                    queryMapperUtil.createHeadSql("select * from user u : " + finalI);
                    System.out.println(queryMapperUtil.toSqlString());
                }
            }).start();
        }
    }

//    @Test
//    void test2() {
//        Map<String, Object> map = new HashMap<String, Object>() {
//            {
//                put("1", 1);
//                put("2", 2);
//                put("3", null);
//            }
//        };
//        Set<Map.Entry<String, Object>> entries = map.entrySet();
//        entries.remove("1");
//        map.remove("1");
////        for (String k : map.keySet()) {
////            if (k.equals("1"));
////            map.remove(k);
////        }
//        map.entrySet().forEach((entry) -> {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        });
//    }

}