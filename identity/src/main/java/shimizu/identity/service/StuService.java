package shimizu.identity.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.Student;
import shimizu.identity.events.TestEvent;
import shimizu.identity.repository.StuRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Shimizu
 */
@Service
@AllArgsConstructor
@Slf4j
public class StuService {
    private final StuRepository stuRepository;
    private final EntityManager entityManager;

    @EventListener
//    @Async
    public void testEventListener(TestEvent testEvent) {
        log.info(testEvent.getStudent().toString());
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(10000);
                log.info("run--------");
                throw new RuntimeException("故意抛出异常");
            }
        }).start();
        try {
            throw new RuntimeException("故意抛出异常2");
        }catch (Exception e){
            log.info("抓住故意抛出的异常2");
        }
    }

}
