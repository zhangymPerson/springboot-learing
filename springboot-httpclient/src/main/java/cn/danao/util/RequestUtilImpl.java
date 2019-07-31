package cn.danao.util;

import cn.danao.bean.RequestInfoModel;
import cn.danao.exception.ExceptionCode;
import cn.danao.exception.GlobalException;
import cn.danao.util.http.RequestMethod;
import cn.danao.util.http.httpclient.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname RequsetUtilImpl
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/31 14:11
 * @since 1.0
 */
@Slf4j
public class RequestUtilImpl implements RequestUtil {

    public HttpClientUtil httpClientUtil = new HttpClientUtil();

    @Override
    public RequestInfoModel sendHttpRequest(RequestInfoModel requestInfoModel) {
        try {
            log.info("请求前参数 [{}] ", requestInfoModel);
            String url = requestInfoModel.getUrl();
            if (StringUtils.isEmpty(url)) {
                return requestInfoModel;
            }
            RequestMethod requestMethod = requestInfoModel.getMethod();
            requestInfoModel.setSendDate(LocalDateTime.now());
            Map<String,Object> result = new HashMap<>();
            Map<String, Object> params = requestInfoModel.getParams();
            if (requestMethod.getName().equals("POST")) {
                if (params == null || params.isEmpty()) {
                    result = httpClientUtil.doPost(url);
                } else {
                    result = httpClientUtil.doPostJson(url, params);
                }
            }
            if (requestMethod.getName().equals("GET")) {
                if (params == null || params.isEmpty()) {
                    result = httpClientUtil.doGet(url);
                } else {
                    result = httpClientUtil.doGet(url, params);
                }
            }
            int code = (int) result.get("code");
            String resultStr = (String) result.get("result");
            requestInfoModel.setResult(resultStr);
            requestInfoModel.setRequestResultStatus(String.valueOf(code));
            requestInfoModel.setResultDate(LocalDateTime.now());
            return requestInfoModel;
        } catch (Exception e) {
            throw new GlobalException(ExceptionCode.EXCEPTION_INFO.fillArgs("发送请求异常,异常信息:" + e.getMessage()));
        }
    }
}
