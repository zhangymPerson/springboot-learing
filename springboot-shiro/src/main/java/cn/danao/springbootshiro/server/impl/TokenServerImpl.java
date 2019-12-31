package cn.danao.springbootshiro.server.impl;

import cn.danao.springbootshiro.bean.User;
import cn.danao.springbootshiro.server.TokenServer;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return token;
    }


}
