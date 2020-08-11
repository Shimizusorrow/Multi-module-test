//package shimizu.identity.auth.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
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
// * @date 2020/7/30 13:39
// */
//@Component
//public class JwtAuthenticationSuccessHandler extends RestAuthenticationHandler {
//    private ObjectMapper objectMapper;
//
//    public JwtAuthenticationSuccessHandler(ObjectMapper objectMapper) {
//        super(objectMapper);
//    }
//
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
