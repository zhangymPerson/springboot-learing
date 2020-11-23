package cn.danao.generator.server.impl;

import cn.danao.generator.dao.UserMapper;
import cn.danao.generator.model.User;
import cn.danao.generator.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date 2020/11/23 15:32 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
