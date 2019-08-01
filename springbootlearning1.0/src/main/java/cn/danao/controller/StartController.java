package cn.danao.controller;

import cn.danao.exception.CodeMsg;
import cn.danao.exception.GlobalException;
import cn.danao.server.FileServer;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname StartController
 * @descriptionclass 1.测试项目启动
 * 2.其他说明
 * @createdate 2019/7/30 17:18
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/start")
@Slf4j
public class StartController {

    @Autowired
    public FileServer fileServer;
    /**
     * 测试项目是否启动
     *
     * @return
     */
    @RequestMapping(value = "/success")
    public String isStart() {
        log.info("测试项目是否启动");
        Map<String, Object> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "测试成功");
        return JSON.toJSONString(result);
    }

    /**
     * 测试get   请求参数
     * 需要两个参数 params:value 和 num:数字 类型与后台代码一致
     *
     * @param argOne
     * @param argTwo
     * @return
     */
    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public String isParams(@RequestParam String argOne, @RequestParam int argTwo) {
        log.info("请求的是参数测试接口，请求参数 [ {} {} ]", argOne, argTwo);
        Map<String, Object> params = new HashMap<>();
        params.put("status", 200);
        params.put("msg", "success");
        params.put("result", "请求参数，argOne = " + argOne + ",argTwo = " + argTwo);
        return JSON.toJSONString(params);
    }

    /**
     * post发送json请求的测试接口
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/params/post/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public String isParamsPostJson(@RequestBody Map<String, Object> params) {
        log.info("请求的是参数测试接口，请求参数 [{}]", params);
        params.put("status", "200");
        params.put("msg", "测试成功");
        return JSON.toJSONString(params);
    }

    /**
     * post发送json请求的测试接口
     *
     * @param argOne
     * @param argTwo
     * @return
     */
    @RequestMapping(value = "/params/post", method = RequestMethod.POST)
    public String isParamsPost(@RequestParam String argOne, @RequestParam String argTwo) {
        log.info("请求的是参数测试接口，请求参数 [{} {}]", argOne, argTwo);
        Map<String, Object> params = new HashMap<>();
        params.put("status", "200");
        params.put("msg", "测试成功" + "参数" + argOne + "," + argTwo);
        return JSON.toJSONString(params);
    }

    /**
     * 上传用Post 关键字名 file 数据类型 文件
     * 问题 获取到的文件名不正确
     * @param fileUpload
     * @return
     */
    @RequestMapping(value = "/commit/file", method = RequestMethod.POST)
    public String commitFile(@RequestParam("file") MultipartFile fileUpload){
        try {
            if (fileUpload != null) {
                String fileName = fileUpload.getName();
                //默认参数对
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("file",fileUpload);
                fileServer.saveFile(params);
                //file
                params.put("file", fileUpload);
                log.info("+++++++++++++" + fileName + fileUpload.isEmpty());
            }
            return "success";
        }catch (Exception e){
            throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs(e.getMessage()));
        }
    }

}
