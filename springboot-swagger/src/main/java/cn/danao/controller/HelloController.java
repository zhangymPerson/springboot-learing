package cn.danao.controller;

import cn.danao.bean.UserInfo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.List;

@Api(value = "消息",description = "消息操作 API", position = 100, protocols = "http")
@RequestMapping("/message")
@ApiOperation(value = "HelloController 请求测试接口",notes = "HelloController 的注释说明")
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);



    @ApiOperation("测试接口 - 注解@ApiOperation")
    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public String  test(){
        logger.info("请求路由为:test"  );
        return "test";
    }


    @ApiOperation(value = "测试组合注解",notes="注意事项")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "id",value = "用户id",required = true,paramType = "path"),
            @ApiImplicitParam(dataType = "string",name = "name",value = "用户信息",required = true,paramType = "body")
    })
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
    @ApiOperation(value = "测试swagger的请求参数配置" ,notes = "参数说明 id 必须为为数字")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "String",paramType = "path")
    @RequestMapping(value="/tests/{id}",method= RequestMethod.GET)
    public String sayHellos(@PathVariable("id") Integer id){
        logger.info("请求/test/"+id);
        return "id:"+id+" name:";
    }

    /**
     * 请求方式 /danao/test1?id=123
     * @param id
     * @return
     */
    @RequestMapping(value="/test1",method= RequestMethod.GET)
    public String sayHello(@RequestParam("id") Integer id){
        logger.info("请求的是/test1" + id );
        return "id:"+id;
    }

    @ApiOperation(
            value = "消息列表",
            notes = "完整的消息内容列表",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = List.class
    )
    @GetMapping(value = "messages")
    private List<UserInfo> list() {
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("zhangsan",10,"男","备注"));
        return userInfos;
    }

}
