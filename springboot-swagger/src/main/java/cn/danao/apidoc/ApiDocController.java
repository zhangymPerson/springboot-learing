package cn.danao.apidoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/8/7 9:55 <br/>
 * description class <br/>
 * apidoc 工具的注释测试
 * 版本 1.0.0
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@Slf4j
public class ApiDocController {


    /**
     * 分组测试
     * @apiDefine groupName 自定义分组名
     */

    /**
     * 分组测试
     * @apiDefine groupName1 自定义分组名1
     */

    /**
     * 分组测试
     * @apiDefine groupName2 自定义分组名2
     */

    /**
     * 分组测试
     * @apiDefine groupName3 自定义分组名3
     */

    /**
     * 自定义异常错误
     * @apiDefine MyError
     * @apiError UserNotFound 指定参数 <code>id</code> 未获取到异常.
     */


    /**
     * @api {get} api01 接口说明  接口作用描述内容
     * @apiName api名字 获取api
     * @apiGroup groupName
     * @apiParam {string} req1 请求值
     * @apiSuccess {String} res1 返回值1
     * @apiSuccessExample Success-Response:
     * {
     * 　　"res1":"test"
     * }
     * @apiVersion 1.0.0
     * @apiUse exception
     * @apiUse MyError
     */
    @RequestMapping(value = "/api01")
    public String apiDoc() {
        log.info("请求路由是api01");
        return "success";
    }


    /**
     * @api {get} api11 接口说明  接口作用描述内容
     * @apiName api名字 获取api
     * @apiGroup groupName1
     * @apiParam {string} req1 请求值
     * @apiSuccess {String} res1 返回值1
     * @apiSuccessExample Success-Response:
     * {
     * 　　"res1":"test"
     * }
     * @apiVersion 1.0.0
     */
    @RequestMapping(value = "/api11")
    public String apiDoc1() {
        log.info("请求路由是api11");
        return "success";
    }

    /**
     * @api {post} api21 接口说明  接口作用描述内容
     * @apiName api名字 获取api
     * @apiGroup groupName2
     * @apiParam {string} req1 请求值
     * @apiSuccess {String} res1 返回值1
     * @apiSuccessExample Success-Response:
     * {
     * 　　"res1":"test"
     * }
     * @apiVersion 1.0.0
     */
    @RequestMapping(value = "/api21")
    public String apiDoc2() {
        log.info("请求路由是api21");
        return "success";
    }

}
