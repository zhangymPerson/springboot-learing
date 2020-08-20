package cn.danao.exception;

/**
 * description class 1.异常枚举
 * create date 2019/7/11 11:29
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class CodeMsg {

    private Long code;
    private String message;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(200L, "success");
    public static CodeMsg FAIL = new CodeMsg(500L, "false");
    public static CodeMsg EXCEPTION_ERROR = new CodeMsg(500L, "服务器运行异常");
    public static CodeMsg EXCEPTION_INFO = new CodeMsg(501L, "服务器运行异常,[%s]");
    public static CodeMsg TOKEN_ERROR = new CodeMsg(502L, "token已失效，请重新登陆");

    //session失效
    public static CodeMsg SESSION_FAIL = new CodeMsg(502001L, "登陆超时，请重新登陆");
    public static CodeMsg LOGIN_FAIL = new CodeMsg(502002L, "登陆失败，请重新登陆");
    public static CodeMsg WEIXIN_LOGIN_FAIL = new CodeMsg(502003L, "微信号未绑定手机");
    public static CodeMsg WEIXIN_AUTH_TIMEOUT = new CodeMsg(502004L, "微信授权超时");
    public static CodeMsg WEIXIN_AUTH_FAIL = new CodeMsg(502005L, "微信授权失败");


    //用户和成员
    public static CodeMsg USER_EXIST = new CodeMsg(500100L, "新手机号已经注册该平台,可以直接使用新手机号登陆");
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(500101L, "用户不存在");
    public static CodeMsg MEMBER_EXIST = new CodeMsg(500102L, "成员已经存在");
    public static CodeMsg MEMBER_NOT_EXIST = new CodeMsg(500103L, "成员不存在");
    public static CodeMsg MEMBER_INFO_NOT_ALL = new CodeMsg(500104L, "请完善基本信息");
    public static CodeMsg MEMBER_CREATE_FAIL = new CodeMsg(500105L, "创建成员失败,原因:[%s]");
    public static CodeMsg MEMBER_COUNT_FULL = new CodeMsg(500106L, "创建成员失败,成员数已达上限");
    public static CodeMsg MEMBER_DELETE_FAIL = new CodeMsg(500107L, "删除成员失败,原因[%s]");

    //短信发送失败
    public static CodeMsg SEND_MSG_ERROR = new CodeMsg(500201L, "发送验证码失败，原因%s");
    public static CodeMsg VERIFYCODE_NOT_EXIST = new CodeMsg(500202L, "验证码已过期");
    public static CodeMsg VERIFYCODE_IS_USER = new CodeMsg(500204L, "验证码已失效，请重新获取");
    public static CodeMsg VERIFYCODE_FAIL = new CodeMsg(500203L, "验证码输入错误");
    public static CodeMsg PHONE_NUM_ERROR = new CodeMsg(500204L, "非法手机号");

    //调用失败
    public static CodeMsg NLP_EXCEPTION = new CodeMsg(500301L, "系统异常，请联系管理员");
    public static CodeMsg TOKEN_NULL = new CodeMsg(500302L, "当前用户无法获取到token");
    public static CodeMsg ML_NULL = new CodeMsg(500303L, "调用推荐系统失败,无法推断疾病和推荐医院");
    public static CodeMsg KN_NULL = new CodeMsg(500304L, "调用知识库失败,无法获取知识库资源");

    //参数
    public static CodeMsg ARG_ERROR = new CodeMsg(500001L, "参数异常");
    public static CodeMsg ARG_ERROR_INFO = new CodeMsg(500002L, "参数异常:%s");
    //就诊卡号错误
    public static CodeMsg HEALTHCARD_ERROR = new CodeMsg(500003L, "卡号无效");
    public static CodeMsg HOSPITAL_NAME_ERROR = new CodeMsg(500004L, "暂不支持该医院绑卡");
    public static CodeMsg SAME_ID_ERROR = new CodeMsg(500005L, "就诊卡已存在");

    //小e健康意图分析失败
    public static CodeMsg INTENTION_FAIL_INFO = new CodeMsg(500500L, "抱歉，暂时无法识别，小e会努力学习的~");

    //上传文件异常
    public static CodeMsg FILE_ERROR_INFO = new CodeMsg(500401L, "上传的文件不能为NULL");


    //修改病历异常
    public static CodeMsg ILLNESSHISTORY_NOT_EXIT = new CodeMsg(500601L, "修改的病历不存在");
    //发送病历异常
    public static CodeMsg SEND_ILLNESS_FAIL = new CodeMsg(500602L, "请完善健康档案");


    public CodeMsg fillArgs(Object... args) {
        Long code = this.code;
        String message = String.format(this.message, args);
        return new CodeMsg(code, message);
    }

    private CodeMsg(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + message + "]";
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
