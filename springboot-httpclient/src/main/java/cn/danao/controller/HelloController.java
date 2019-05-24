package cn.danao.controller;

import cn.danao.bean.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/test")
    public String  test(){
        logger.info("请求路由为:test"  );
        return "test";
    }

    @RequestMapping(value="/tests/{id}/{name}",method= RequestMethod.GET)
    public Object sayHello(@PathVariable("id") Integer id,@PathVariable("name") String name){
       logger.info("请求/test/"+id+"/"+name);
        UserInfo userInfos = new UserInfo(id,name,12,"男","备注");
        return userInfos;
    }


    /**
     * 请求的数据类型需要与定义的一致
     * @param id
     * @return
     */
    @RequestMapping(value="/tests/{id}",method= RequestMethod.GET)
    public String sayHellos(@PathVariable("id") Integer id){
        logger.info("请求/test/"+id);
        return "id:"+id+" name:";
    }

    /**
     * 请求方式 /zym/test1?id=123
     * @param id
     * @return
     */
    @RequestMapping(value="/test1",method= RequestMethod.GET)
    public String sayHello(@RequestParam("id") Integer id){
        logger.info("请求的是/test1" + id );
        return "id:"+id;
    }

}