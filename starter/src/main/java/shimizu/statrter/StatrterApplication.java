package shimizu.statrter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {
        "shimizu.common",
        "shimizu.app",
        "shimizu.identity"
})
//@EnableFeignClients
@SpringBootConfiguration
public class StatrterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatrterApplication.class, args);
    }

}
