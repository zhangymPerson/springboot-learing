package cn.danao.controller;

import cn.danao.bean.ResultCode;
import cn.danao.exception.CodeMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/8/20 11:19 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Api(tags = "swagger接口返回对象测试")
@RestController
public class SwaggerController {
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String test() {
        String result = "{\n" +
                "  \"info\": \"v2 start success\"\n" +
                "}";
        return result;
    }

    /**
     * 测试数据返回
     *
     * @return
     */
    @ApiOperation(value = "启动测试接口,返回正确返回数据demo")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ResultCode success() {
        return ResultCode.SUCCESS;
    }


    @ApiOperation(value = "启动测试接口,返回错误数据demo")
    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public ResultCode fail() {
        return ResultCode.ERROR;
    }

    @ApiOperation(value = "启动测试接口,异常返回demo")
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public ResultCode exception() {
        try {
            int i = 0;
            int j = 1 / i;
            return ResultCode.SUCCESS;
        } catch (Exception e) {
            //错误信息。先做包装处理
            return ResultCode.resultCode(CodeMsg.EXCEPTION_INFO.fillArgs(e.getMessage()));
        }
    }
}
