package cn.danao.server;

import cn.danao.bean.User;

/**
 * date 2020/6/1 14:57 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface UserServer {
    /**
     * 获取用户
     *
     * @return
     */
    User getUser();
}
