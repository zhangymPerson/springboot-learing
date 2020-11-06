package cn.danao.springboot.springbootkotlin.bean

/**
 * date 2020/8/19 17:23 <br></br>
 * description class <br></br>
 * 返回对象包装类
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
class ResultCode {
    /**
     * 状态码
     * 成功 = 200
     * 失败 = 其他异常情况
     */
    var code = 0

    /**
     * 结果说明
     * 成功 = success
     * 失败 = 其他异常情况
     */
    var message: String? = null

    /**
     * 版本号
     */
    val version: String = "2.0"


    /**
     * 返回结果数据
     */
    var result: Any? = null

    constructor() : super() {}
    constructor(obj: Any?) {
        code = 200
        message = "success"
        result = obj
    }

    constructor(code: Int, message: String?, result: Any?) {
        this.code = code
        this.message = message
        this.result = result
    }

    companion object {
        /**
         * 请求成功返回对象
         */
        var SUCCESS = ResultCode(200, "success", null)

        /**
         * 请求失败返回对象
         */
        var ERROR = ResultCode(500, "fail", null)

        /**
         * 请求返回包装对象
         */
        fun resultCode(obj: Any?): ResultCode {
            return ResultCode(200, "success", obj)
        }
    }
}