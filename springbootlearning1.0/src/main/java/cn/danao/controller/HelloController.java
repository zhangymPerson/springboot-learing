package cn.danao.controller;

import cn.danao.bean.ResultCode;
import cn.danao.bean.UserInfo;
import cn.danao.conf.PropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试请求的controller
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);


    private PropertiesConfig propertiesConfig;


    @Autowired
    public HelloController(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
    }

    @RequestMapping(value = "/test")
    public String test() {
        logger.info("请求路由为:test");

        //测试读取配置 文件方式 1
        //String test = PropertyPlaceholder.getPropertyForStr("test");
        //String test1 = PropertyPlaceholder.getPropertyForStr("test1");
        //logger.info("test {}  test1 {}",test,test1);

        //注解方式2
        logger.info("proTest {}", propertiesConfig.proTest);


        return "test";
    }

    @RequestMapping(value = "/tests/{id}/{name}", method = RequestMethod.GET)
    public Object sayHello(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        logger.info("请求/test/" + id + "/" + name);
        UserInfo userInfos = new UserInfo(id, name, 12, "男", "备注");
        return userInfos;
    }


    /**
     * 请求的数据类型需要与定义的一致
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/tests/{id}", method = RequestMethod.GET)
    public String sayHellos(@PathVariable("id") Integer id) {
        logger.info("请求/test/" + id);
        return "id:" + id + " name:";
    }

    /**
     * 请求方式 /danao/test1?id=123
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String sayHello(@RequestParam("id") Integer id) {
        logger.info("请求的是/test1" + id);
        return "id:" + id;
    }

    @GetMapping(value = "/token")
    public String getTokenTest(HttpServletRequest request, @RequestParam("word") String word, @RequestParam("type") String type) {
        logger.info("token = {} word = {} ,type = {}", request.getHeader("token"), word, type);
        return "success";
    }

    /**
     * 配置 restful请求
     * 其中请求方式为 get 时，配置请求参数可以为空的场景
     * 第一：配置路由
     * 第二：参数注解使用 required=false
     * 否则，保存404找不到路由
     *
     * @param id
     * @param date
     * @return
     */
    @RequestMapping(value = {"/get/{id}/{date}", "/get/{id}"})
    public ResultCode getHospitalInfo(@PathVariable String id, @PathVariable(required = false) String date) {
        logger.info("id={},date={}", id, date);
        return ResultCode.SUCCESS;
    }
}
