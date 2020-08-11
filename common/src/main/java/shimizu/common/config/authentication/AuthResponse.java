//package shimizu.common.config.authentication;
//
//import static javax.servlet.http.HttpServletResponse.*;
//
///**
// * 请求失败的消息实体
// *
// * @author zzk
// * @data 2018/10/10
// */
//public class AuthResponse {
//
//    private int code;
//
//    private String message;
//
//
//    static AuthResponse unAuthenticationResponse = new AuthResponse(SC_UNAUTHORIZED, "用户未认证或认证已过期");
//
//    static AuthResponse errorAuthenticationResponse = new AuthResponse(SC_BAD_REQUEST, "用户名或密码错误");
//
//    static AuthResponse logoutResponse = new AuthResponse(SC_OK, "用户退出成功");
//
//    static AuthResponse nonAuthorityResponse = new AuthResponse(SC_FORBIDDEN, "权限不足");
//
//
//    private AuthResponse(int code, String message) {
//        this.code = code;
//        this.message = message;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//
//    public String getMessage() {
//        return message;
//    }
//
//}
