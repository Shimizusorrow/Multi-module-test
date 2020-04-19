package shimizu.statrter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.shimizu.common"
})
//@EnableFeignClients
public class StatrterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatrterApplication.class, args);
    }

}
