package cn.danao.server;

import cn.danao.bean.UserInfo;

public interface UserServer {

    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    public UserInfo getUser(int userId);

    /**
     * 创建用户
     */
    public void createUser(UserInfo userInfo);

}
