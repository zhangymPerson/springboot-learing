package cn.danao.server.impl;

import cn.danao.bean.UserInfo;
import cn.danao.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname UserServerImpl
 * @descriptionclass
 * 1.Server注解使用测试
 * 2.server的实现需要使用@Server注解 如果只有一个实现，可以省略里面内容 如果多个则需要用别名 在引用的位置使用@Qualifier("别名") 引入当前实现
 * @createdate 2019/6/18 15:50
 * @since 1.0
 */
//@Service("userServer")
@Service("userServer1")
public class UserServerImpl  implements UserServer {

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
        userInfo.setRemark("我是服务1的修改");
        list.add(userInfo);
    }
}
