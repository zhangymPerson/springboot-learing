package cn.danao.dao;

import cn.danao.bean.User;

/**
 * mongo 数据操作第二种方式
 */
public interface UserDao {
    /**
     * 添加用户信息
     * @param user {@link User}
     */
    void insert(User user);

    /**
     * 更新用户信息
     * @param user {@link User}
     */
    void update(User user);

    /**
     * 根据用户id查询
     * @param id id
     * @return {@link User}
     */
    User findById(String id);}
