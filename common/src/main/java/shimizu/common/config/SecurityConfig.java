//package shimizu.common.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CompositeFilter;
//import shimizu.identity.auth.UserInfo;
//import shimizu.identity.auth.jwt.JwtAuthenticationProvider;
//import shimizu.identity.auth.jwt.JwtAuthenticationSuccessHandler;
//import shimizu.identity.auth.jwt.JwtFilter;
//import shimizu.identity.auth.web.WebAuthenticationFilter;
//import shimizu.common.config.authentication.RestAccessDeniedHandler;
//import shimizu.common.config.authentication.RestAuthenticationEntryPoint;
//import shimizu.common.config.authentication.SimpleLogoutHandler;
//
//import javax.servlet.Filter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
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
//
//
//    private final JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;
//    private final AuthenticationFailureHandler authenticationFailureHandler;
//    private final SimpleLogoutHandler simpleLogoutHandler;
//    private final JwtFilter jwtFilter;
//    private final UserInfo userInfo;
//    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//    private final RestAccessDeniedHandler restAccessDeniedHandler;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        AuthenticationManager am = this.authenticationManager();
//
//        http.cors()
//                .and()
//                .csrf().disable()
//                .addFilterBefore(ssoFilter(am), BasicAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(restAuthenticationEntryPoint)
//                .accessDeniedHandler(restAccessDeniedHandler)
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
//                .logoutSuccessHandler(simpleLogoutHandler)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.singletonList("*"));
//        configuration.setAllowedMethods(Collections.singletonList("*"));
//        configuration.addAllowedHeader("X-Auth-Token");
//        configuration.addExposedHeader("X-Auth-Token");
//        configuration.addAllowedHeader("content-type");
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//
//    private Filter ssoFilter(AuthenticationManager am) {
//        CompositeFilter compositeFilter = new CompositeFilter();
//        List<Filter> filters = new ArrayList<>();
//
//        //Web登录
//        addFilter(am, filters, new WebAuthenticationFilter());
//
////        //单警柜登录
////        addFilter(am, filters, new PoliceCabinetAuthenticationFilter());
////
////        //人脸登录
////        addFilter(am, filters, new FaceAuthenticationFilter());
//
//        compositeFilter.setFilters(filters);
//        return compositeFilter;
//    }
//
//    /**
//     * 统一为过滤器设置成功失败处理
//     *
//     * @param am
//     * @param filters
//     * @param filter
//     */
//    private void addFilter(AuthenticationManager am, List<Filter> filters, AbstractAuthenticationProcessingFilter filter) {
//        filter.setAuthenticationManager(am);
//        filter.setAuthenticationSuccessHandler(jwtAuthenticationSuccessHandler);
//        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
//        filters.add(filter);
//    }
//
////    /**
////     * 配置认证校验提供器
////     *
////     * @param auth
////     * @throws Exception
////     */
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .authenticationProvider(new WebAuthenticationProvider(userInfo))
////                .authenticationProvider(new PoliceCabinetAuthenticationProvider(userInfo))
////                .authenticationProvider(new FaceAuthenticationProvider(userInfo));
//////                userDetailsService(identityService)
//////                .passwordEncoder(NoOpPasswordEncoder.getInstance());
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //解决静态资源被拦截的问题
//        web.ignoring().mvcMatchers("/api/**");
//    }
//}
