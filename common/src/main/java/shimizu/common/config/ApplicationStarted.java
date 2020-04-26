package shimizu.common.config;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import shimizu.common.bos.BosResult;

import java.util.HashMap;

/**
 * @description:  Application启动后自动扫描
 * @author: Shimizu
 * @date: 2020/4/23 14:49
 * @param:
 * @return:
 */
@Component
public class ApplicationStarted implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Class<?> mainClass = event.getSpringApplication().getMainApplicationClass();
    }
}
