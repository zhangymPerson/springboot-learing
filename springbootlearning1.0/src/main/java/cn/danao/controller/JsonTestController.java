package cn.danao.controller;

import cn.danao.bean.ResultCode;
import cn.danao.bean.UserInfo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author danao
 * @version 1.0
 * @classname JsonTestController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/17 17:01
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/json")
@Slf4j
public class JsonTestController {

    @RequestMapping(value = "/test/{test}",method = RequestMethod.POST)
    public ResultCode test(@PathVariable("test") String test){
        log.info("test {}",test);
        return ResultCode.SUCCESS;
    }


    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ResultCode createUserJson(){
        UserInfo userInfo = new UserInfo("ma",21,"男","测试");
        String userInfoJson = JSON.toJSONString(userInfo);
        //{"age":21,"id":0,"name":"ma","remark":"测试","sex":"男"}
        log.info("userInfoJson {} " , userInfoJson);
        return ResultCode.getResultCode(userInfo);
    }


    /**
     * 请求格式为post请求
     * 请求内容为json串 {"age":21,"id":0,"name":"ma","remark":"测试","sex":"男"}
     * 请求头设置为 Content-Type ： application/json
     * Body的格式为row
     * Spring接收json 的bean对象必须有无参构造函数
     * Spring 接收json必须使用@RequestBody注解
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/test",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public ResultCode testJson(@RequestBody UserInfo userInfo){
        log.info("userInfo {}",userInfo);
        return ResultCode.SUCCESS;
    }

    @RequestMapping(value = "/tests",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public ResultCode testJsons(@RequestBody UserInfo userInfo){
        log.info("userInfo {}",userInfo);
        return ResultCode.SUCCESS;
    }

}
