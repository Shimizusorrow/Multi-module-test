//package shimizu.common.config.authentication;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 认证失败的逻辑处理。
// * 主要是消除登录失败的页面重定向。
// *
// * @author zzk
// * @date 2018/10/10
// */
//@Component
//public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException
//            exception) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//        PrintWriter out = response.getWriter();
//        out.write(objectMapper.writeValueAsString(AuthResponse.errorAuthenticationResponse));
//        out.flush();
//        out.close();
//    }
//}
