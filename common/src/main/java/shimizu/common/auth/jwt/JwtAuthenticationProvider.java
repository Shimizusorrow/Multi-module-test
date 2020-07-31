//package shimizu.common.auth.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.DefaultClaims;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.AccountExpiredException;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import shimizu.common.basedomain.User;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Jwt 认证
// * @author Shimizu
// * @version 1.0
// * @date 2020/7/30 8:26
// */
//@Component
//@AllArgsConstructor
//public class JwtAuthenticationProvider implements AuthenticationProvider {
//    private final JwtProperties jwtProperties;
//    private final ObjectMapper objectMapper;
//
//    /**
//     * 若是 http 请求，则从 http请求 header中获取的参数名
//     */
//    final String headerParamName = "x-auth-token";
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String token;
//        boolean isString = authentication.getCredentials() instanceof String;
//        if (!isString) {
//            return null;
//        } else {
//            token = (String) authentication.getCredentials();
//        }
//        try {
//            UserDetails user = getUserFromJwt(token);
//            return user != null ? new UsernamePasswordAuthenticationToken(user,
//                    user.getPassword(),
//                    user.getAuthorities()) : null;
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public UserDetails getUserFromJwt(String token) {
//        final Jws<Claims> jws = Jwts.parser()
//                .setSigningKey(jwtProperties.getSalt())
//                .parseClaimsJws(token);
//        DefaultClaims claims = (DefaultClaims) jws.getBody();
//
//        return claims.containsKey("user") ? objectMapper.convertValue(claims.get("user"), User.class) : null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//
//    public String writeToken(UserDetails userDetails) {
//        final Date now = new Date();
//        return Jwts
//                .builder()
//                .addClaims((Map<String, Object>) new HashMap<>(0).put("user", userDetails))
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + jwtProperties.getExpirationTime()))
//                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSalt())
//                .compact();
//    }
//
//    public boolean validateToken(String token) throws AccountExpiredException {
//        Jws<Claims> claims = Jwts.parser()
//                .setSigningKey(jwtProperties.getSalt())
//                .parseClaimsJws(token);
//        return !claims.getBody().getExpiration().before(new Date());
//    }
//}
