package cn.danao.controller;

import cn.danao.bean.vo.VarModel;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * date 2020/8/10 16:29 <br/>
 * description class <br/>
 * 参数规则校验检测接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RequestMapping(value = "/val")
@RestController
@Slf4j
public class ValidatorController {

    /**
     * post发送json请求的测试接口
     * 当使用 @Valid 注解时才会校验参数
     * 测试路由 post json
     * http://127.0.0.1:8080/danao/val/var
     * 测试用例
     * {"age":12,"birthday":1597052041502,"email":"123@163.com","expire":1597052041502,"flag":true,"list":[12,32],"name":"test","pass":"pass","range":2334,"salary":344,"url":"http://baidu.com","value":"3"}
     *
     * @return
     */
    @RequestMapping(value = "/var", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public String isParamsPostJson(@RequestBody @Valid VarModel varModel) {
        log.info("请求的是参数测试接口，请求参数 [{}]", varModel);
        return JSON.toJSONString("success");
    }
}
