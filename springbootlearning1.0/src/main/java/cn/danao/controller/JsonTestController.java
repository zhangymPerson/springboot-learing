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
        return ResultCode.SUCCESS;
    }


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResultCode testJson(@RequestBody UserInfo userInfo){
        log.info("userInfo ()",userInfo);
        return ResultCode.SUCCESS;
    }


}
