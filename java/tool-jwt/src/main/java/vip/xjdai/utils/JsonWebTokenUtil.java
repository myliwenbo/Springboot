package vip.xjdai.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultHeader;
import io.jsonwebtoken.impl.DefaultJwsHeader;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import vip.xjdai.model.BaseConstants;
import vip.xjdai.model.JwtAccount;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class JsonWebTokenUtil
{
    //秘钥
    public static final  String                   SECRET_KEY    = "abcdefg";
    private static final ObjectMapper             MAPPER        = new ObjectMapper();
    private static       CompressionCodecResolver codecResolver = new DefaultCompressionCodecResolver();

    //私有化构造
    private JsonWebTokenUtil()
    {
    }

    /* *
     * @Description  json web token 签发
     * @param id 令牌ID
     * @param subject 用户标识
     * @param issuer 签发人
     * @param period 有效时间(秒)
     * @param roles 访问主张-角色
     * @param permissions 访问主张-权限
     * @param algorithm 加密算法
     * @Return java.lang.String
     */
    public static String issueJWT(String id, String subject, String issuer, Long period, String roles,
                                  String permissions, SignatureAlgorithm algorithm)
    {
        // 当前时间戳
        Long currentTimeMillis = System.currentTimeMillis();
        // 秘钥
        byte[]     secreKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        JwtBuilder jwtBuilder    = Jwts.builder();
        if (StringUtils.isNotBlank(id)) {
            jwtBuilder.setId(id);
        }
        if (StringUtils.isNotBlank(subject)) {
            jwtBuilder.setSubject(subject);
        }
        if (StringUtils.isNotBlank(issuer)) {
            jwtBuilder.setIssuer(issuer);
        }
        // 设置签发时间
        jwtBuilder.setIssuedAt(new Date(currentTimeMillis));
        // 设置到期时间
        if (null != period) {
            jwtBuilder.setExpiration(new Date(currentTimeMillis + period * 1000));
        }
        if (StringUtils.isNotBlank(roles)) {
            jwtBuilder.claim("roles", roles);
        }
        if (StringUtils.isNotBlank(permissions)) {
            jwtBuilder.claim("perms", permissions);
        }
        // 压缩，可选GZIP
        jwtBuilder.compressWith(CompressionCodecs.DEFLATE);
        // 加密设置
        jwtBuilder.signWith(algorithm, secreKeyBytes);
        return jwtBuilder.compact();
    }

    /**
     * 解析JWT的Payload
     */
    public static String parseJwtPayload(String jwt)
    {
        Assert.hasText(jwt, "JWT String argument cannot be null or empty.");
        String        base64UrlEncodedHeader  = null;
        String        base64UrlEncodedPayload = null;
        String        base64UrlEncodedDigest  = null;
        int           delimiterCount          = 0;
        StringBuilder sb                      = new StringBuilder(128);
        for (char c : jwt.toCharArray()) {
            if (c == '.') {
                CharSequence tokenSeq = io.jsonwebtoken.lang.Strings.clean(sb);
                String token = tokenSeq != null ?
                        tokenSeq.toString() :
                        null;

                if (delimiterCount == 0) {
                    base64UrlEncodedHeader = token;
                } else if (delimiterCount == 1) {
                    base64UrlEncodedPayload = token;
                }

                delimiterCount++;
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (delimiterCount != 2) {
            String msg = "JWT strings must contain exactly 2 period characters. Found: " + delimiterCount;
            throw new MalformedJwtException(msg);
        }
        if (sb.length() > 0) {
            base64UrlEncodedDigest = sb.toString();
        }
        if (base64UrlEncodedPayload == null) {
            throw new MalformedJwtException("JWT string '" + jwt + "' is missing a body/payload.");
        }
        // =============== Header =================
        Header           header           = null;
        CompressionCodec compressionCodec = null;
        if (base64UrlEncodedHeader != null) {
            String                origValue = TextCodec.BASE64URL.decodeToString(base64UrlEncodedHeader);
            Map< String, Object > m         = readValue(origValue);
            if (base64UrlEncodedDigest != null) {
                header = new DefaultJwsHeader(m);
            } else {
                header = new DefaultHeader(m);
            }
            compressionCodec = codecResolver.resolveCompressionCodec(header);
        }
        // =============== Body =================
        String payload;
        if (compressionCodec != null) {
            byte[] decompressed = compressionCodec.decompress(TextCodec.BASE64URL.decode(base64UrlEncodedPayload));
            payload = new String(decompressed, io.jsonwebtoken.lang.Strings.UTF_8);
        } else {
            payload = TextCodec.BASE64URL.decodeToString(base64UrlEncodedPayload);
        }
        return payload;
    }

    /**
     * 验签JWT
     *
     * @param jwt json web token
     */
    public static JwtAccount parseJwt(String jwt,
                                      String appKey) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException
    {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(appKey)).parseClaimsJws(
                jwt).getBody();
        JwtAccount jwtAccount = new JwtAccount();
        //令牌ID
        jwtAccount.setTokenId(claims.getId());
        //客户标识
        String subject = claims.getSubject();
        jwtAccount.setSubject(subject);
        //用户id
        jwtAccount.setUserId(subject);
        //签发者
        jwtAccount.setIssuer(claims.getIssuer());
        //签发时间
        jwtAccount.setIssuedAt(claims.getIssuedAt());
        //接收方
        jwtAccount.setAudience(claims.getAudience());
        //访问主张-角色
        jwtAccount.setRoles(claims.get("roles", String.class));
        //访问主张-权限
        jwtAccount.setPerms(claims.get("perms", String.class));
        return jwtAccount;
    }

    public static Map< String, Object > readValue(String val)
    {
        try {
            return MAPPER.readValue(val, Map.class);
        } catch (IOException e) {
            throw new MalformedJwtException("Unable to userpager JSON value: " + val, e);
        }
    }
}
