//package shimizu.identity.auth;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.stereotype.Component;
//import shimizu.identity.domain.base.User;
//import shimizu.common.basedomain.UserRepository;
//import shimizu.common.exception.BusinessException;
//
///**
// * 获取用户信息
// *
// * @author Curtain
// * @date 2019/2/26 14:23
// */
//@Component
//public class UserInfo {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public User getUser(String username) {
//        User user;
//        try {
//            user = userRepository.findByAccountNumber(username);
//        } catch (BusinessException e) {
//            throw new BadCredentialsException("用户不存在");
//        }
//        return user;
//    }
//}
