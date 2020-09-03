package cn.danao.springboot.springbootkotlin.server.impl;

import cn.danao.springboot.springbootkotlin.bean.UserTwo;
import cn.danao.springboot.springbootkotlin.server.UserTwoServer;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * date 2020/9/3 9:53 <br/>
 * description class <br/>
 * java实现kotlin接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service(value = "userTwoServerJava")
@Slf4j
public class UserTwoServerImpl implements UserTwoServer {

    private static List<UserTwo> userTwos = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            UserTwo two = new UserTwo();
            two.setName("name" + i);
            two.setOther("备注");
            userTwos.add(two);
        }
    }

    @NotNull
    @Override
    public UserTwo getUserTwo(int id) {
        log.info("请求UserTwoServerJava服务，请求id {} ", id);
        List<UserTwo> collect = userTwos.stream().filter(k -> ("name" + id).equals(k.getName())).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return new UserTwo();
        } else {
            return collect.get(0);
        }
    }

    @NotNull
    @Override
    public List<UserTwo> getAllUserTwo() {
        return userTwos;
    }
}
