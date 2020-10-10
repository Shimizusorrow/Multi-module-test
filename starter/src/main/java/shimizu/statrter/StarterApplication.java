package shimizu.statrter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import shimizu.common.config.LearnApplicationContextInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.*;

/**
 * @author Shimizu
 */
@SpringBootApplication(scanBasePackages = {
        "shimizu.common",
        "shimizu.app",
        "shimizu.identity"
})
@SpringBootConfiguration
@EnableConfigurationProperties
public class StarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
//        SpringApplication app = new SpringApplication(StarterApplication.class);
//        app.addInitializers(new LearnApplicationContextInitializer());
//        app.run(args);
    }

}
