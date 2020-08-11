//package shimizu.identity.auth.web;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Shimizu
// * @version 1.0
// * @date 2020/7/29 15:57
// */
//public class WebAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//    public WebAuthenticationFilter() {
//        super(new AntPathRequestMatcher("/login", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
//        return null;
//    }
//
//
//}
