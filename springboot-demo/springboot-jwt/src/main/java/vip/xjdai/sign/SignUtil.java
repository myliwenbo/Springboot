/**
 *
 */
package vip.xjdai.sign;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.google.common.collect.Maps;

/**
 * @author lwb
 *
 */
public class SignUtil {

    private final static Long EXPITRED_TIME = 15L * 1000;
    private final static String SECRET = "abcdef";

    public static String sign(String username, String userId) {
        //过期算法
        Date expired = new Date(System.currentTimeMillis() + EXPITRED_TIME);
        //私钥以及加密算法
        Algorithm hmac256 = Algorithm.HMAC256(SECRET);
        //设置头部信息
        Map<String, Object> head = Maps.newHashMap();
        head.put(PublicClaims.TYPE, "JWT");
        head.put(PublicClaims.ALGORITHM, "hmac256");
        Builder create = JWT.create();
        create.withHeader(head);//添加头信息
        create.withClaim("username", username);//添加自定义声明值。
        create.withClaim("userId", userId);//添加自定义声明值。
        create.withExpiresAt(expired);//添加过期时间
        return create.sign(hmac256);//添加私钥
    }

    public static Boolean verify(String token) {
        try {
            Algorithm hmac256 = Algorithm.HMAC256(SECRET);
            Verification require = JWT.require(hmac256);
            JWTVerifier build = require.build();
            DecodedJWT verify = build.verify(token);
            System.out.println(verify.getToken());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
