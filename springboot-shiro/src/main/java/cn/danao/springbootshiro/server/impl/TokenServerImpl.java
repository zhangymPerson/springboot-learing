package cn.danao.springbootshiro.server.impl;

import cn.danao.springbootshiro.bean.User;
import cn.danao.springbootshiro.constant.SecretConstant;
import cn.danao.springbootshiro.server.TokenServer;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * date 2019/12/31 17:21 <br/>
 * descriptionclass <br/>
 * token 服务实现
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
@Slf4j
public class TokenServerImpl implements TokenServer {

    @Override
    public String getUserToken(User user) {
        String token;
        // 将 user id 保存到 token 里面
        token = JWT.create().withAudience(user.getId())
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getPassword()));
        log.info("User {} token {}", user, token);
        return createToken(user);
    }


    private String createToken(User user) {
        //签名算法，选择SHA-256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取当前系统时间
        long nowTimeMillis = System.currentTimeMillis();
        Date now = new Date(nowTimeMillis);
        //将BASE64SECRET常量字符串使用base64解码成字节数组
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SecretConstant.BASE64SECRET);
        //使用HmacSHA256签名算法生成一个HS256的签名秘钥Key
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //添加构成JWT的参数
        Map<String, Object> headMap = new HashMap<>();
        /*
            Header
            {
              "alg": "HS256",
              "typ": "JWT"
            }
         */
        headMap.put("alg", SignatureAlgorithm.HS256.getValue());
        headMap.put("typ", "JWT");
        JwtBuilder builder = Jwts.builder().setHeader(headMap)
                /*
                    Payload
                    {
                      "userId": "1234567890",
                      "userName": "John Doe",
                    }
                 */
                //加密后的客户编号
                .claim("userId", user.getId())
                //客户名称
                .claim("userName", user.getUsername())
                //客户端浏览器信息
                .claim("userAgent", "无")
                //Signature 算法
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (SecretConstant.EXPIRESSECOND >= 0) {
            long expMillis = nowTimeMillis + SecretConstant.EXPIRESSECOND;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate).setNotBefore(now);
        }
        return builder.compact();
    }

    @Override
    public void checkToken(String token) {
        //解析token
        Claims claims = null;
        try {
            if (!StringUtils.isEmpty(token)) {
                //解析jwt
                claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SecretConstant.BASE64SECRET))
                        .parseClaimsJws(token).getBody();
                log.info("解析后的token {}", claims);
            } else {
                log.warn("[JWTHelper]-json web token 为空");
            }
        } catch (Exception e) {
            log.error("[JWTHelper]-JWT解析异常：可能因为token已经超时或非法token");
        }
    }
}
