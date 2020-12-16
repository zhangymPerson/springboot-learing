package cn.danao.server;

import cn.danao.bean.UserInfo;

/**
 * 测试mock的接口
 */
public interface MockService {

    /**
     * 根据id获取用户
     *
     * @param userId
     * @return
     */
    public UserInfo getUser(int userId);

}
