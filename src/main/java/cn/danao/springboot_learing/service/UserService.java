package cn.danao.springboot_learing.service;

import cn.danao.springboot_learing.dao.User;

import java.util.Map;

/**
 * date 2024/10/16 17:31 <br/>
 * description interface UserService<br/>
 *
 * @author zym
 */
public interface UserService {

    /**
     * 新增
     */
    public Object insert(User user);

    /**
     * 删除
     */
    public Object delete(int id);

    /**
     * 更新
     */
    public Object update(User user);

    /**
     * 根据主键 id 查询
     */
    public User load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}