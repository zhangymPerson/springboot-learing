package cn.danao.springboot.springbootkotlin.server;

import cn.danao.springboot.springbootkotlin.bean.UserOne;

import java.util.List;

/**
 * date 2020/9/2 17:48 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface UserServer {

    /**
     * 获取指定编号的用户
     *
     * @param userId
     * @return
     */
    UserOne getUserOneById(Integer userId);

    /**
     * 获取所有的用户
     *
     * @return
     */
    List<UserOne> getAllUserOne();
}
