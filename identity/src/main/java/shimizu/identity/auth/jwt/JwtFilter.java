//package shimizu.identity.auth.jwt;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Shimizu
// * @version 1.0
// * @date 2020/8/10 10:47
// */
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//    private final JwtAuthenticationProvider jwtAuthenticationProvider;
//
//    public JwtFilter(JwtAuthenticationProvider jwtAuthenticationProvider) {
//        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//    }
//}
