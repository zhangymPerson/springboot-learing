package cn.danao.controller;

import cn.danao.bean.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author danao
 * @version 1.0
 * @classname PostController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/27 14:26
 * @since 1.0
 */
@RestController
@RequestMapping(value = "post")
public class PostController {


    public Logger logger = LoggerFactory.getLogger(PostController.class);
    /**
     * 无参的post的请求
     * @return
     */
    @RequestMapping(value = "/noparams",method = RequestMethod.POST)
    public ResultCode test(){
        logger.info("无参post请求测试");
        return ResultCode.SUCCESS;
    }

    /**
     * 测试post参数测试
    * @param id 数字
     * @param string 字符串
     * @return
     */
    @RequestMapping(value = "/params",method = RequestMethod.POST)
    public ResultCode testParams(int id, String string ){
        logger.info(String.format("post请求参数测试; id : %s string : %s",id,string));
        return ResultCode.SUCCESS;
    }

    @RequestMapping(value = "/restful/{id}/{name}" ,method = RequestMethod.POST)
    public ResultCode testRestFul(@PathVariable("id") int id, @PathVariable("name") String name){
        logger.info(String.format("post restful请求id %s name %s",id,name));
        return ResultCode.SUCCESS;
    }

}
