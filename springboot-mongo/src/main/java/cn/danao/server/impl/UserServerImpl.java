package cn.danao.server.impl;

import cn.danao.bean.User;
import cn.danao.dao.UserTwoDao;
import cn.danao.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date 2020/10/14 11:45 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserTwoDao userTwoDao;

    @Override
    public User getUser(String name) {
        return userTwoDao.findByName(name);
    }
}
