package cn.danao.apidoc;

/**
 * date 2020/8/7 10:59 <br/>
 * description class <br/>
 * 异常api
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ExceptionController {
    /**
     * 配置异常分组 （共有模块）
     * @apiDefine exception
     * 接口异常说明
     * @apiError (400) paramsError 参数错误
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "UserNotFound"
     *     }
     */
}
