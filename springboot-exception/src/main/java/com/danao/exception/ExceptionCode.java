package com.danao.exception;

/**
 * @author danao
 * @version 1.0
 * @classname EeceptionCode
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/23 10:09
 * @since 1.0
 */
public class ExceptionCode {

    public static ExceptionCode DEFAULT = new ExceptionCode();
    public static ExceptionCode BYZERO = new ExceptionCode("501", "除数不能为0");
    public static ExceptionCode SELF = new ExceptionCode("511", "自定义异常");
    public static ExceptionCode SELF_INFO = new ExceptionCode("510", "自定义异常，异常信息：%s");
    public static ExceptionCode SUCCESS = new ExceptionCode("00000", "成功");

    //=============================================阿里巴巴错误码代码=============================================================
    //客户端错误
    public static ExceptionCode USER_ERROR_0001 = new ExceptionCode("A0001", "用户端错误");
    public static ExceptionCode USER_ERROR_A0100 = new ExceptionCode("A0100", "用户注册错误");
    public static ExceptionCode USER_ERROR_A0101 = new ExceptionCode("A0101", "用户未同意隐私协议");
    public static ExceptionCode USER_ERROR_A0102 = new ExceptionCode("A0102", "注册国家或地区受限");
    public static ExceptionCode USER_ERROR_A0110 = new ExceptionCode("A0110", "用户名校验失败");
    public static ExceptionCode USER_ERROR_A0111 = new ExceptionCode("A0111", "用户名已存在");
    public static ExceptionCode USER_ERROR_A0112 = new ExceptionCode("A0112", "用户名包含敏感词");
    public static ExceptionCode USER_ERROR_A0113 = new ExceptionCode("A0113", "用户名包含特殊字符");
    public static ExceptionCode USER_ERROR_A0120 = new ExceptionCode("A0120", "密码校验失败");
    public static ExceptionCode USER_ERROR_A0121 = new ExceptionCode("A0121", "密码长度不够");
    public static ExceptionCode USER_ERROR_A0122 = new ExceptionCode("A0122", "密码强度不够");
    public static ExceptionCode USER_ERROR_A0130 = new ExceptionCode("A0130", "校验码输入错误");
    public static ExceptionCode USER_ERROR_A0131 = new ExceptionCode("A0131", "短信校验码输入错误");
    public static ExceptionCode USER_ERROR_A0132 = new ExceptionCode("A0132", "邮件校验码输入错误");
    public static ExceptionCode USER_ERROR_A0133 = new ExceptionCode("A0133", "语音校验码输入错误");
    public static ExceptionCode USER_ERROR_A0140 = new ExceptionCode("A0140", "用户证件异常");
    public static ExceptionCode USER_ERROR_A0141 = new ExceptionCode("A0141", "用户证件类型未选择");
    public static ExceptionCode USER_ERROR_A0142 = new ExceptionCode("A0142", "大陆身份证编号校验非法");
    public static ExceptionCode USER_ERROR_A0143 = new ExceptionCode("A0143", "护照编号校验非法");
    public static ExceptionCode USER_ERROR_A0144 = new ExceptionCode("A0144", "军官证编号校验非法");
    public static ExceptionCode USER_ERROR_A0150 = new ExceptionCode("A0150", "用户基本信息校验失败");
    public static ExceptionCode USER_ERROR_A0151 = new ExceptionCode("A0151", "手机格式校验失败");
    public static ExceptionCode USER_ERROR_A0152 = new ExceptionCode("A0152", "地址格式校验失败");
    public static ExceptionCode USER_ERROR_A0153 = new ExceptionCode("A0153", "邮箱格式校验失败");
    public static ExceptionCode USER_ERROR_A0200 = new ExceptionCode("A0200", "用户登陆异常");
    public static ExceptionCode USER_ERROR_A0201 = new ExceptionCode("A0201", "用户账户不存在");
    public static ExceptionCode USER_ERROR_A0202 = new ExceptionCode("A0202", "用户账户被冻结");
    public static ExceptionCode USER_ERROR_A0203 = new ExceptionCode("A0203", "用户账户已作废");
    public static ExceptionCode USER_ERROR_A0210 = new ExceptionCode("A0210", "用户密码错误");
    public static ExceptionCode USER_ERROR_A0211 = new ExceptionCode("A0211", "用户输入密码次数超限");
    public static ExceptionCode USER_ERROR_A0220 = new ExceptionCode("A0220", "用户身份校验失败");
    public static ExceptionCode USER_ERROR_A0221 = new ExceptionCode("A0221", "用户指纹识别失败");
    public static ExceptionCode USER_ERROR_A0222 = new ExceptionCode("A0222", "用户面容识别失败");
    public static ExceptionCode USER_ERROR_A0223 = new ExceptionCode("A0223", "用户未获得第三方登陆授权");
    public static ExceptionCode USER_ERROR_A0230 = new ExceptionCode("A0230", "用户登陆已过期");
    public static ExceptionCode USER_ERROR_A0240 = new ExceptionCode("A0240", "用户验证码错误");
    public static ExceptionCode USER_ERROR_A0241 = new ExceptionCode("A0241", "用户验证码尝试次数超限");
    public static ExceptionCode USER_ERROR_A0300 = new ExceptionCode("A0300", "访问权限异常");
    public static ExceptionCode USER_ERROR_A0301 = new ExceptionCode("A0301", "访问未授权");
    public static ExceptionCode USER_ERROR_A0302 = new ExceptionCode("A0302", "正在授权中");
    public static ExceptionCode USER_ERROR_A0303 = new ExceptionCode("A0303", "用户授权申请被拒绝");
    public static ExceptionCode USER_ERROR_A0310 = new ExceptionCode("A0310", "因访问对象隐私设置被拦截");
    public static ExceptionCode USER_ERROR_A0311 = new ExceptionCode("A0311", "授权已过期");
    public static ExceptionCode USER_ERROR_A0312 = new ExceptionCode("A0312", "无权限使用API");
    public static ExceptionCode USER_ERROR_A0320 = new ExceptionCode("A0320", "用户访问被拦截");
    public static ExceptionCode USER_ERROR_A0321 = new ExceptionCode("A0321", "黑名单用户");
    public static ExceptionCode USER_ERROR_A0322 = new ExceptionCode("A0322", "账号被冻结");
    public static ExceptionCode USER_ERROR_A0323 = new ExceptionCode("A0323", "非法IP地址");
    public static ExceptionCode USER_ERROR_A0324 = new ExceptionCode("A0324", "网关访问受限");
    public static ExceptionCode USER_ERROR_A0325 = new ExceptionCode("A0325", "地域黑名单");
    public static ExceptionCode USER_ERROR_A0330 = new ExceptionCode("A0330", "服务已欠费");
    public static ExceptionCode USER_ERROR_A0340 = new ExceptionCode("A0340", "用户签名异常");
    public static ExceptionCode USER_ERROR_A0341 = new ExceptionCode("A0341", "RSA签名错误");
    public static ExceptionCode USER_ERROR_A0400 = new ExceptionCode("A0400", "用户请求参数错误");
    public static ExceptionCode USER_ERROR_A0401 = new ExceptionCode("A0401", "包含非法恶意跳转链接");
    public static ExceptionCode USER_ERROR_A0402 = new ExceptionCode("A0402", "无效的用户输入");
    public static ExceptionCode USER_ERROR_A0410 = new ExceptionCode("A0410", "请求必填参数为空");
    public static ExceptionCode USER_ERROR_A0411 = new ExceptionCode("A0411", "用户订单号为空");
    public static ExceptionCode USER_ERROR_A0412 = new ExceptionCode("A0412", "订购数量为空");
    public static ExceptionCode USER_ERROR_A0413 = new ExceptionCode("A0413", "缺少时间戳参数");
    public static ExceptionCode USER_ERROR_A0414 = new ExceptionCode("A0414", "非法的时间戳参数");
    public static ExceptionCode USER_ERROR_A0420 = new ExceptionCode("A0420", "请求参数值超出允许的范围");
    public static ExceptionCode USER_ERROR_A0421 = new ExceptionCode("A0421", "参数格式不匹配");
    public static ExceptionCode USER_ERROR_A0422 = new ExceptionCode("A0422", "地址不在服务范围");
    public static ExceptionCode USER_ERROR_A0423 = new ExceptionCode("A0423", "时间不在服务范围");
    public static ExceptionCode USER_ERROR_A0424 = new ExceptionCode("A0424", "金额超出限制");
    public static ExceptionCode USER_ERROR_A0425 = new ExceptionCode("A0425", "数量超出限制");
    public static ExceptionCode USER_ERROR_A0426 = new ExceptionCode("A0426", "请求批量处理总个数超出限制");
    public static ExceptionCode USER_ERROR_A0427 = new ExceptionCode("A0427", "请求JSON解析失败");
    public static ExceptionCode USER_ERROR_A0430 = new ExceptionCode("A0430", "用户输入内容非法");
    public static ExceptionCode USER_ERROR_A0431 = new ExceptionCode("A0431", "包含违禁敏感词");
    public static ExceptionCode USER_ERROR_A0432 = new ExceptionCode("A0432", "图片包含违禁信息");
    public static ExceptionCode USER_ERROR_A0433 = new ExceptionCode("A0433", "文件侵犯版权");
    public static ExceptionCode USER_ERROR_A0440 = new ExceptionCode("A0440", "用户操作异常");
    public static ExceptionCode USER_ERROR_A0441 = new ExceptionCode("A0441", "用户支付超时");
    public static ExceptionCode USER_ERROR_A0442 = new ExceptionCode("A0442", "确认订单超时");
    public static ExceptionCode USER_ERROR_A0443 = new ExceptionCode("A0443", "订单已关闭");
    public static ExceptionCode USER_ERROR_A0500 = new ExceptionCode("A0500", "用户请求服务异常");
    public static ExceptionCode USER_ERROR_A0501 = new ExceptionCode("A0501", "请求次数超出限制");
    public static ExceptionCode USER_ERROR_A0502 = new ExceptionCode("A0502", "请求并发数超出限制");
    public static ExceptionCode USER_ERROR_A0503 = new ExceptionCode("A0503", "用户操作请等待");
    public static ExceptionCode USER_ERROR_A0504 = new ExceptionCode("A0504", "WebSocket连接异常");
    public static ExceptionCode USER_ERROR_A0505 = new ExceptionCode("A0505", "WebSocket连接断开");
    public static ExceptionCode USER_ERROR_A0506 = new ExceptionCode("A0506", "用户重复请求");
    public static ExceptionCode USER_ERROR_A0600 = new ExceptionCode("A0600", "用户资源异常");
    public static ExceptionCode USER_ERROR_A0601 = new ExceptionCode("A0601", "账户余额不足");
    public static ExceptionCode USER_ERROR_A0602 = new ExceptionCode("A0602", "用户磁盘空间不足");
    public static ExceptionCode USER_ERROR_A0603 = new ExceptionCode("A0603", "用户内存空间不足");
    public static ExceptionCode USER_ERROR_A0604 = new ExceptionCode("A0604", "用户OSS容量不足");
    public static ExceptionCode USER_ERROR_A0605 = new ExceptionCode("A0605", "用户配额已用光");
    public static ExceptionCode USER_ERROR_A0700 = new ExceptionCode("A0700", "用户上传文件异常");
    public static ExceptionCode USER_ERROR_A0701 = new ExceptionCode("A0701", "用户上传文件类型不匹配");
    public static ExceptionCode USER_ERROR_A0702 = new ExceptionCode("A0702", "用户上传文件太大");
    public static ExceptionCode USER_ERROR_A0703 = new ExceptionCode("A0703", "用户上传图片太大");
    public static ExceptionCode USER_ERROR_A0704 = new ExceptionCode("A0704", "用户上传视频太大");
    public static ExceptionCode USER_ERROR_A0705 = new ExceptionCode("A0705", "用户上传压缩文件太大");
    public static ExceptionCode USER_ERROR_A0800 = new ExceptionCode("A0800", "用户当前版本异常");
    public static ExceptionCode USER_ERROR_A0801 = new ExceptionCode("A0801", "用户安装版本与系统不匹配");
    public static ExceptionCode USER_ERROR_A0802 = new ExceptionCode("A0802", "用户安装版本过低");
    public static ExceptionCode USER_ERROR_A0803 = new ExceptionCode("A0803", "用户安装版本过高");
    public static ExceptionCode USER_ERROR_A0804 = new ExceptionCode("A0804", "用户安装版本已过期");
    public static ExceptionCode USER_ERROR_A0805 = new ExceptionCode("A0805", "用户API请求版本不匹配");
    public static ExceptionCode USER_ERROR_A0806 = new ExceptionCode("A0806", "用户API请求版本过高");
    public static ExceptionCode USER_ERROR_A0807 = new ExceptionCode("A0807", "用户API请求版本过低");
    public static ExceptionCode USER_ERROR_A0900 = new ExceptionCode("A0900", "用户隐私未授权");
    public static ExceptionCode USER_ERROR_A0901 = new ExceptionCode("A0901", "用户隐私未签署");
    public static ExceptionCode USER_ERROR_A0902 = new ExceptionCode("A0902", "用户摄像头未授权");
    public static ExceptionCode USER_ERROR_A0903 = new ExceptionCode("A0903", "用户相机未授权");
    public static ExceptionCode USER_ERROR_A0904 = new ExceptionCode("A0904", "用户图片库未授权");
    public static ExceptionCode USER_ERROR_A0905 = new ExceptionCode("A0905", "用户文件未授权");
    public static ExceptionCode USER_ERROR_A0906 = new ExceptionCode("A0906", "用户位置信息未授权");
    public static ExceptionCode USER_ERROR_A0907 = new ExceptionCode("A0907", "用户通讯录未授权");
    public static ExceptionCode USER_ERROR_A1000 = new ExceptionCode("A1000", "用户设备异常");
    public static ExceptionCode USER_ERROR_A1001 = new ExceptionCode("A1001", "用户相机异常");
    public static ExceptionCode USER_ERROR_A1002 = new ExceptionCode("A1002", "用户麦克风异常");
    public static ExceptionCode USER_ERROR_A1003 = new ExceptionCode("A1003", "用户听筒异常");
    public static ExceptionCode USER_ERROR_A1004 = new ExceptionCode("A1004", "用户扬声器异常");
    public static ExceptionCode USER_ERROR_A1005 = new ExceptionCode("A1005", "用户GPS定位异常");
    //系统错误
    public static ExceptionCode SYSTEM_ERROR_B0001 = new ExceptionCode("B0001", "系统执行出错");
    public static ExceptionCode SYSTEM_ERROR_B0100 = new ExceptionCode("B0100", "系统执行超时");
    public static ExceptionCode SYSTEM_ERROR_B0101 = new ExceptionCode("B0101", "系统订单处理超时");
    public static ExceptionCode SYSTEM_ERROR_B0200 = new ExceptionCode("B0200", "系统容灾功能被触发");
    public static ExceptionCode SYSTEM_ERROR_B0210 = new ExceptionCode("B0210", "系统限流");
    public static ExceptionCode SYSTEM_ERROR_B0220 = new ExceptionCode("B0220", "系统功能降级");
    public static ExceptionCode SYSTEM_ERROR_B0300 = new ExceptionCode("B0300", "系统资源异常");
    public static ExceptionCode SYSTEM_ERROR_B0310 = new ExceptionCode("B0310", "系统资源耗尽");
    public static ExceptionCode SYSTEM_ERROR_B0311 = new ExceptionCode("B0311", "系统磁盘空间耗尽");
    public static ExceptionCode SYSTEM_ERROR_B0312 = new ExceptionCode("B0312", "系统内存耗尽");
    public static ExceptionCode SYSTEM_ERROR_B0313 = new ExceptionCode("B0313", "文件句柄耗尽");
    public static ExceptionCode SYSTEM_ERROR_B0314 = new ExceptionCode("B0314", "系统连接池耗尽");
    public static ExceptionCode SYSTEM_ERROR_B0315 = new ExceptionCode("B0315", "系统线程池耗尽");
    public static ExceptionCode SYSTEM_ERROR_B0320 = new ExceptionCode("B0320", "系统资源访问异常");
    public static ExceptionCode SYSTEM_ERROR_B0321 = new ExceptionCode("B0321", "系统读取磁盘文件失败");
    //服务错误
    public static ExceptionCode SERVICE_ERROR_C0001 = new ExceptionCode("C0001", "调用第三方服务出错");
    public static ExceptionCode SERVICE_ERROR_C0100 = new ExceptionCode("C0100", "中间件服务出错");
    public static ExceptionCode SERVICE_ERROR_C0110 = new ExceptionCode("C0110", "RPC服务出错");
    public static ExceptionCode SERVICE_ERROR_C0111 = new ExceptionCode("C0111", "RPC服务未找到");
    public static ExceptionCode SERVICE_ERROR_C0112 = new ExceptionCode("C0112", "RPC服务未注册");
    public static ExceptionCode SERVICE_ERROR_C0113 = new ExceptionCode("C0113", "接口不存在");
    public static ExceptionCode SERVICE_ERROR_C0120 = new ExceptionCode("C0120", "消息服务出错");
    public static ExceptionCode SERVICE_ERROR_C0121 = new ExceptionCode("C0121", "消息投递出错");
    public static ExceptionCode SERVICE_ERROR_C0122 = new ExceptionCode("C0122", "消息消费出错");
    public static ExceptionCode SERVICE_ERROR_C0123 = new ExceptionCode("C0123", "消息订阅出错");
    public static ExceptionCode SERVICE_ERROR_C0124 = new ExceptionCode("C0124", "消息分组未查到");
    public static ExceptionCode SERVICE_ERROR_C0130 = new ExceptionCode("C0130", "缓存服务出错");
    public static ExceptionCode SERVICE_ERROR_C0131 = new ExceptionCode("C0131", "key长度超过限制");
    public static ExceptionCode SERVICE_ERROR_C0132 = new ExceptionCode("C0132", "value长度超过限制");
    public static ExceptionCode SERVICE_ERROR_C0133 = new ExceptionCode("C0133", "存储容量已满");
    public static ExceptionCode SERVICE_ERROR_C0134 = new ExceptionCode("C0134", "不支持的数据格式");
    public static ExceptionCode SERVICE_ERROR_C0140 = new ExceptionCode("C0140", "配置服务出错");
    public static ExceptionCode SERVICE_ERROR_C0150 = new ExceptionCode("C0150", "网络资源服务出错");
    public static ExceptionCode SERVICE_ERROR_C0151 = new ExceptionCode("C0151", "VPN服务出错");
    public static ExceptionCode SERVICE_ERROR_C0152 = new ExceptionCode("C0152", "CDN服务出错");
    public static ExceptionCode SERVICE_ERROR_C0153 = new ExceptionCode("C0153", "域名解析服务出错");
    public static ExceptionCode SERVICE_ERROR_C0154 = new ExceptionCode("C0154", "网关服务出错");
    public static ExceptionCode SERVICE_ERROR_C0200 = new ExceptionCode("C0200", "第三方系统执行超时");
    public static ExceptionCode SERVICE_ERROR_C0210 = new ExceptionCode("C0210", "RPC执行超时");
    public static ExceptionCode SERVICE_ERROR_C0220 = new ExceptionCode("C0220", "消息投递超时");
    public static ExceptionCode SERVICE_ERROR_C0230 = new ExceptionCode("C0230", "缓存服务超时");
    public static ExceptionCode SERVICE_ERROR_C0240 = new ExceptionCode("C0240", "配置服务超时");
    public static ExceptionCode SERVICE_ERROR_C0250 = new ExceptionCode("C0250", "数据库服务超时");
    public static ExceptionCode SERVICE_ERROR_C0300 = new ExceptionCode("C0300", "数据库服务出错");
    public static ExceptionCode SERVICE_ERROR_C0311 = new ExceptionCode("C0311", "表不存在");
    public static ExceptionCode SERVICE_ERROR_C0312 = new ExceptionCode("C0312", "列不存在");
    public static ExceptionCode SERVICE_ERROR_C0321 = new ExceptionCode("C0321", "多表关联中存在多个相同名称的列");
    public static ExceptionCode SERVICE_ERROR_C0331 = new ExceptionCode("C0331", "数据库死锁");
    public static ExceptionCode SERVICE_ERROR_C0341 = new ExceptionCode("C0341", "主键冲突");
    public static ExceptionCode SERVICE_ERROR_C0400 = new ExceptionCode("C0400", "第三方容灾系统被触发");
    public static ExceptionCode SERVICE_ERROR_C0401 = new ExceptionCode("C0401", "第三方系统限流");
    public static ExceptionCode SERVICE_ERROR_C0402 = new ExceptionCode("C0402", "第三方功能降级");
    public static ExceptionCode SERVICE_ERROR_C0500 = new ExceptionCode("C0500", "通知服务出错");
    public static ExceptionCode SERVICE_ERROR_C0501 = new ExceptionCode("C0501", "短信提醒服务失败");
    public static ExceptionCode SERVICE_ERROR_C0502 = new ExceptionCode("C0502", "语音提醒服务失败");
    public static ExceptionCode SERVICE_ERROR_C0503 = new ExceptionCode("C0503", "邮件提醒服务失败");
    //=============================================阿里巴巴错误码代码=============================================================
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private ExceptionCode() {
        this.code = "500";
        this.msg = "未知错误";
    }

    private ExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ExceptionCode fillArgs(String... args) {
        String code = this.code;
        String message = String.format(this.msg, args);
        return new ExceptionCode(code, message);
    }

    public ExceptionCode fillClassNameArgs(Class classObject, String... args) {
        String code = this.code;
        String message = String.format(this.msg, args);
        String msg = String.format("异常类:%s,异常信息:%s", classObject.getName(), message);
        return new ExceptionCode(code, msg);
    }

}
