package shimizu.statrter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shimizu
 */
@SpringBootApplication(scanBasePackages = {
        "shimizu.common",
        "shimizu.app",
        "shimizu.identity"
})

@SpringBootConfiguration
@EnableSwagger2
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

}
