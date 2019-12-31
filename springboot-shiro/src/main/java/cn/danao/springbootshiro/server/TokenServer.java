package cn.danao.springbootshiro.server;

import cn.danao.springbootshiro.bean.User;

/**
 * date 2019/12/31 17:18 <br/>
 * descriptionclass <br/>
 * <p>
 * Token 服务
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface TokenServer {


    /**
     * 获取用户的token值
     *
     * @param user 用户信息
     * @return 生成简单token测试
     */
    String getUserToken(User user);
}
