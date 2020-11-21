package shimizu.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import shimizu.app.AppApplication;
import shimizu.identity.IdentityApplication;

/**
 * @author Shimizu
 */
@SpringBootApplication(scanBasePackages = {
        "shimizu.starter",
        "shimizu.common",
        "shimizu.app",
        "shimizu.identity"
})
//@SpringBootApplication(
//        scanBasePackageClasses = {
//                StarterApplication.class,
//                IdentityApplication.class,
//                AppApplication.class
//        }
//)
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
