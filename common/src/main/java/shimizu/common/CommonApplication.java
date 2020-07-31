package shimizu.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//@ComponentScan(
//        basePackages = {"shimizu.common.auth"},
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {
//                        shimizu.common.auth.jwt.JwtAuthenticationProvider.class,
//                        shimizu.common.auth.jwt.JwtAuthenticationSuccessHandler.class,
//                        shimizu.common.auth.jwt.JwtProperties.class,
//                        shimizu.common.auth.jwt.RestAuthenticationHandler.class,
//                        shimizu.common.auth.web.WebAuthenticationFilter.class
//                })
//        })
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
