//package shimizu.common.config.authentication;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 认证失败的逻辑处理
// *
// * @author zzk
// * @date 2018/10/10
// */
//@Component
//public class RestAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        out.write(objectMapper.writeValueAsString(AuthResponse.nonAuthorityResponse));
//        out.flush();
//        out.close();
//    }
//}
