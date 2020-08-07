package cn.danao.apidoc;

import org.springframework.stereotype.Controller;

/**
 * date 2020/8/7 10:28 <br/>
 * description class <br/>
 * token校验 apidoc测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Controller
public class TokenController {
    /**
     * 定义一个接口组 权限
     */
    /**
     * @apiDefine auth 接口需要权限
     * 需要在请求头中添加token参数才能请求 参考 使用前必读
     *
     */

    /**
     * @apiDefine noAuth 接口不需要权限
     * 不需要登陆即可访问
     */

    /**
     * 分组测试
     * @apiDefine login 登陆/注册接口
     */

    /**
     * @api {get} /noAuth 获取token
     * @apiName GetUser
     * @apiGroup login
     * @apiParam {string} req1 请求值
     * @apiSuccess {String} res1 返回值1
     * @apiSuccessExample Success-Response:
     * {
     * 　　res1:"test"
     * }
     * @apiVersion 1.0.0
     * @apiPermission noAuth
     */
    public void noAuth() {
    }
}
