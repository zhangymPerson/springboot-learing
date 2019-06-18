package cn.danao.server.impl;

import cn.danao.bean.UserInfo;
import cn.danao.server.UserServer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname UserServerImpl
 * @descriptionclass
 * 1.Server注解使用测试
 * 2.其他说明
 * @createdate 2019/6/18 15:50
 * @since 1.0
 */
//@Service("userServer")
@Service("userServer2")
public class UserServerImpls implements UserServer {

    public static List<UserInfo> list = new ArrayList<>();

    @Override
    public UserInfo getUser(int userId) {
        if(list == null || list.size() == 0){
            return null;
        }
        for(UserInfo u : list){
            if(u.getId() == userId){
                return u;
            }
        }
        return null;
    }

    @Override
    public void createUser(UserInfo userInfo) {
        if(userInfo == null){
            return;
        }
        userInfo.setRemark("我是服务2的修改");
        list.add(userInfo);
    }
}
