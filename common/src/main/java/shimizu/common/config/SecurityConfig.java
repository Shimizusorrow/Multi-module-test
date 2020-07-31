//package shimizu.common.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import shimizu.common.auth.jwt.JwtAuthenticationProvider;
//import shimizu.common.auth.jwt.JwtAuthenticationSuccessHandler;
//
///**
// * @author Shimizu
// * @version 1.0
// * @date 2020/7/29 15:58
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//    //    private final RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
//    private final JwtAuthenticationSuccessHandler restAuthenticationSuccessHandler;
//
//    private final JwtAuthenticationProvider jwtAuthenticationProvider;
//
//    private final AuthenticationFailureHandler authenticationFailureHandler;
//
//
////    private final JwtFilter jwtFilter;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        AuthenticationManager am = this.authenticationManager();
//
//        http.cors()
//                .and()
//                .csrf().disable()
////                .addFilterBefore(ssoFilter(am), BasicAuthenticationFilter.class)
//                .exceptionHandling()
////                .authenticationEntryPoint(restAuthenticationEntryPoint)
////                .accessDeniedHandler(restAccessDeniedHandler)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/public/**", "/graphql", "/login").permitAll()
////                .antMatchers().hasRole("RoleEnum")
//                .antMatchers("/**").permitAll()
//                .and()
////                .formLogin()
////                .loginPage("/login")
////                .successHandler(restAuthenticationSuccessHandler)
////                .failureHandler(authenticationFailureHandler)
////                .and()
//                //暂时不要限制登录
////                .sessionManagement().maximumSessions(1).and()
////                .and()
//                //配置x-frameOptionsHeaderWriter  以后可以直接配置成同源的 SAMEORIGIN  因为以后会同源
////                .headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
//                .headers().frameOptions().disable()
////                .and()
////                .headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new WhiteListedAllowFromStrategy(Arrays.asList("http://127.0.0.1:8080/","http://192.168.10.187:8088/", "http://183.245.77.242:8088/"))))
//                .and()
//                .logout()
////                .logoutSuccessHandler(simpleLogoutHandler)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
////        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //忽略swagger访问权限限制
//        // web.ignoring().antMatchers(
//        //        "/userlogin",
//        //    "/userlogout",
//        //     "/userjwt",
//        //   "/v2/api-docs",
//        //   "/swagger-resources/configuration/ui",
//        //  "/swagger-resources",
//        // "/swagger-resources/configuration/security",
//        //"/swagger-ui.html",
//        //"/css/**",
//        //"/js/**",
//        //"/images/**",
//        //"/webjars/**",
//        //"**/favicon.ico",
//        //"/index");
//        super.configure(web);
//        //解决静态资源被拦截的问题
//        web.ignoring().mvcMatchers("/api/**");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 加入自定义的安全认证
//        auth     //添加自定义的认证管理类
//                .authenticationProvider(jwtAuthenticationProvider);
//
//    }
//
//    /**
//     * @Description 自定义加密
//     * @Date 2019/7/10 15:07
//     * @Version 1.0
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
