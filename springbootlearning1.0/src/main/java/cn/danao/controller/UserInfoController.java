package cn.danao.controller;

import cn.danao.bean.ResultCode;
import cn.danao.bean.UserInfo;
import cn.danao.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danao
 * @version 1.0
 * @classname UserInfoController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/18 15:55
 * @since 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    @Qualifier("userServer1")
    public UserServer userServers1;

    /**
     * 多个server实现时，可以通过Qualifier 注解来确认使用的是哪一个服务
     */
    @Autowired
    @Qualifier("userServer2")
    public UserServer userServers2;


    @RequestMapping(value = "/test")
    public ResultCode test(){
        return ResultCode.SUCCESS;
    }

    @RequestMapping(value = "/create/1",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public ResultCode createUser(@RequestBody UserInfo userInfo){
        log.info("{}" ,userInfo);
        userServers1.createUser(userInfo);
        UserInfo u = userServers1.getUser(userInfo.getId());
        return ResultCode.getResultCode(u);
    }

    @RequestMapping(value = "/create/2",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public ResultCode createUserTwo(@RequestBody UserInfo userInfo){
        log.info("{}" ,userInfo);
        userServers2.createUser(userInfo);
        UserInfo u = userServers2.getUser(userInfo.getId());
        return ResultCode.getResultCode(u);
    }
}
