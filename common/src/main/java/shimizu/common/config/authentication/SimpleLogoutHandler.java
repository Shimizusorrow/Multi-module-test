//package shimizu.common.config.authentication;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 用户退出处理。
// * 取消了 url 重定向。返回状态码 200,并提示退出成功。
// */
//@Component
//public class SimpleLogoutHandler extends SimpleUrlLogoutSuccessHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//            throws IOException {
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//        PrintWriter out = response.getWriter();
//        out.write(objectMapper.writeValueAsString(AuthResponse.logoutResponse));
//        out.flush();
//        out.close();
//    }
//}
