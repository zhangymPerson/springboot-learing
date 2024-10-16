package cn.danao.springboot_learing.service.impl;

import cn.danao.springboot_learing.dao.User;
import cn.danao.springboot_learing.mapper.UserMapper;
import cn.danao.springboot_learing.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date 2024/10/16 17:32 <br/>
 * description class UserServiceImpl<br/>
 *
 * @author zym
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public Object insert(User user) {

        // valid
        if (user == null) {
            return null;
        }

        userMapper.insert(user);
        return 1;
    }


    @Override
    public Object delete(int id) {
        int ret = userMapper.delete(id);
        return ret;
    }


    @Override
    public Object update(User user) {
        int ret = userMapper.update(user);
        return ret;
    }


    @Override
    public User load(int id) {
        return userMapper.load(id);
    }


    @Override
    public Map<String, Object> pageList(int offset, int pagesize) {

        List<User> pageList = userMapper.pageList(offset, pagesize);
        int totalCount = userMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

}