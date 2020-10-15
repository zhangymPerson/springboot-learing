package cn.danao.server;

import cn.danao.bean.User;

/**
 * date 2020/10/14 11:44 <br/>
 * description class <br/>
 * 用户查询服务
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface UserServer {

    User getUser(String name);
}
