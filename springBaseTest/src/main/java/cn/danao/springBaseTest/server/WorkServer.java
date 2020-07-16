package cn.danao.springBaseTest.server;

import java.util.Map;

/**
 * date 2020/7/16 17:29 <br/>
 * description class <br/>
 * 工作接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface WorkServer {

    /**
     * 自定义工作内容
     *
     * @param params
     * @return
     */
    Map<String, Object> doWork(Map<String, Object> params);

}
