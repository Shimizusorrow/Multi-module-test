//package shimizu.identity.auth.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//import shimizu.identity.domain.base.User;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
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
//@AllArgsConstructor
//public class RestAuthenticationHandler implements AuthenticationSuccessHandler {
//    private final ObjectMapper objectMapper;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
//
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        objectMapper.writeValue(httpServletResponse.getOutputStream(), principal);
//        outputStream.flush();
//    }
//}
