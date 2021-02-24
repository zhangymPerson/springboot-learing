package cn.danao.controller;

import cn.danao.bean.ResultCode;
import cn.danao.bean.vo.MemberVo;
import cn.danao.bean.vo.SessionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2021/2/24 11:46 <br/>
 * description class <br/>
 * 测试参数校验
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/arg")
@Slf4j
public class ArgsController {

    @RequestMapping(value = "/one", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultCode one(@Validated @RequestBody SessionVo sessionVo) {
        log.info("请求sessionVo={}", sessionVo);
        return ResultCode.SUCCESS;
    }

    @RequestMapping(value = "/two", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultCode two(@Validated @RequestBody MemberVo memberVo) {
        log.info("请求 memberVo={}", memberVo);
        return ResultCode.SUCCESS;
    }

    /**
     * 以下这种写法有问题,input流只能读取一次,需要多次读取需要单独处理
     *
     * @param sessionVo
     * @param memberVo
     * @return
     */
    @RequestMapping(value = "/three", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultCode three(@Validated @RequestBody SessionVo sessionVo, @Validated @RequestBody MemberVo memberVo) {
        log.info("请求sessionVo={}, memberVo = {}", sessionVo, memberVo);
        return ResultCode.SUCCESS;
    }
}
