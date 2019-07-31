package cn.danao.bean;

import cn.danao.util.http.RequestMethod;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author zym
 * @version 1.0.0
 * @className RequestInfoModel
 * @descriptionclass 请求信息封装
 * @createdate 2019-07-31 14:04:25
 */
@Data
public class RequestInfoModel {

    //Class属性
    /**
     * 编号
     */
    private String id;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求头内容
     */
    private Map<String, String> heard;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    /**
     * 请求方式
     */
    private RequestMethod method;

    /**
     * 请求体内容
     */
    private String body;

    /**
     * 请求返回结果
     */
    private String result;

    /**
     * 请求结果状态
     */
    private String requestResultStatus;

    /**
     * 请求发送状态
     */
    private String requestSendStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 请求发送时间
     */
    private LocalDateTime sendDate;

    /**
     * 请求响应时间
     */
    private LocalDateTime resultDate;

}
