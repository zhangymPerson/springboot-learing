package cn.danao.util;

import cn.danao.bean.RequestInfoModel;

/**
 * @author danao
 * @version 1.0
 * @classname RequestUtil
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/31 14:08
 * @since 1.0
 */
public interface RequestUtil {

    /**
     * 请求发送
     * @param requestInfoModel
     * @return
     */
    RequestInfoModel sendHttpRequest(RequestInfoModel requestInfoModel);


}
