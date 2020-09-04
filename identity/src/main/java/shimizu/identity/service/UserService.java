package shimizu.identity.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.Student;
import shimizu.identity.events.TestEvent;
import shimizu.identity.repository.UserRepository;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/11 16:02
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    private void testPublish() {
        applicationEventPublisher.publishEvent(new TestEvent(
                new Student()
        ));
    }

    /**
     * 测试事件发布 失败后是否会继续执行下面的结果 答案false 不会
     */
    public void testEventFail() {
        testPublish();
        for (int i = 0; i < 10; i++) {
            log.info("是否会继续执行???");
        }
    }
}
