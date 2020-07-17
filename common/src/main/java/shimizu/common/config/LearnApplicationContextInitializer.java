package shimizu.common.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @author Shimizu
 */
@Order(123) // @Order的value值越小越早执行
public class LearnApplicationContextInitializer implements ApplicationContextInitializer {
   @Override
   public void initialize(ConfigurableApplicationContext applicationContext) {
      // 打印容器里面初始化了多少个Bean
      System.out.println("容器中初始化Bean数量：" + applicationContext.getBeanDefinitionCount());
   }
}