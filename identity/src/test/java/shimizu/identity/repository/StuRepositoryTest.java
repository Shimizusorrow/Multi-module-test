package shimizu.identity.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shimizu.identity.service.query.StuQueryService;

import java.util.Arrays;
import java.util.List;

@SpringBootTest  // 替代ContextConfiguration来指定上下文
@RunWith(SpringRunner.class)
        // 用什么来运行测试，例如可以用Junit4.Class
//@AutoConfigureMockMvc// 模拟web环境,因为@SpringBootTest并不启动server
class StuRepositoryTest {

    @Autowired
    private StuRepository stuRepository;
    @Autowired
    private StuQueryService stuQueryService;

    @Test
    void findOne() {
//        System.out.println(stuRepository.findOne("1"));
        System.out.println(stuRepository.findOne("1").getName());
//        System.out.println(stuRepository.findAll());

    }

    @Test
    void findByName() {
        System.out.println(stuQueryService.findByName("1").getName());
    }

    @Test
    void testAnnotion() {
//        ClassPathScanningCandidateComponentProvider c = new ClassPathScanningCandidateComponentProvider(false);
//        c.addExcludeFilter();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
//        integers.add(1);
//        Collections
        integers.clear();
        System.out.println(integers.size());
    }
}