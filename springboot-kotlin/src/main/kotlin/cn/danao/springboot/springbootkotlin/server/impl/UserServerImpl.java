package cn.danao.springboot.springbootkotlin.server.impl;

import cn.danao.springboot.springbootkotlin.bean.UserOne;
import cn.danao.springboot.springbootkotlin.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * date 2020/9/2 17:51 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service(value = "userServerJava")
@Slf4j
public class UserServerImpl implements UserServer {
    public static List<UserOne> datas = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            UserOne one = new UserOne();
            one.setId(i);
            one.setUserName("name" + i);
            one.setRemark("备注");
            datas.add(one);
        }
    }

    @Override
    public UserOne getUserOneById(Integer userId) {
        log.info("调用的java代码,查询的用户id是{}", userId);
        List<UserOne> collect = datas.stream().filter(k -> k.getId().equals(userId)).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return new UserOne();
        } else {
            return collect.get(0);
        }
    }

    @Override
    public List<UserOne> getAllUserOne() {
        log.info("调用的是java的查询全部方法");
        return datas;
    }
}
