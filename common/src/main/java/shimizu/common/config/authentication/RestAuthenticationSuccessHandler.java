//package shimizu.common.config.authentication;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//import org.springframework.stereotype.Component;
//import shimizu.common.basedomain.User;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 认证成功处理。
// * 主要是去除重定向功能，并返回登录的用户的部分信息
// *
// * @author zzk
// * @date 2018/10/10
// */
//@Component
//public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    private RequestCache requestCache = new HttpSessionRequestCache();
//
//    private static final SerializerFeature[] serializerFeatures;
//
//    //...
//    static {
//        serializerFeatures = new SerializerFeature[]{
////                SerializerFeature.WriteMapNullValue,
////                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.DisableCircularReferenceDetect
//        };
//    }
//
//    RestAuthenticationSuccessHandler() {
//        super();
//    }
//
//    @Override
//    public void onAuthenticationSuccess(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication)
//            throws IOException {
//
//        SavedRequest savedRequest
//                = requestCache.getRequest(request, response);
//
//        if (savedRequest == null) {
//            clearAuthenticationAttributes(request);
//            //返回文本数据
//            response.setContentType("application/json;charset=utf-8");
//            ServletOutputStream outputStream = response.getOutputStream();
//            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            outputStream.write(JSON.toJSONString(principal).getBytes("UTF-8"));
//            outputStream.flush();
//            outputStream.close();
//
//        }
//
//    }
//
//}
