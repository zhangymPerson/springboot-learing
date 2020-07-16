package cn.danao.springBaseTest.server.impl;

import cn.danao.springBaseTest.server.WorkServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/7/16 17:30 <br/>
 * description class <br/>
 * 工作内容实现
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Service
@Primary
public class WorkServerImpl implements WorkServer {
    @Override
    public Map<String, Object> doWork(Map<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            log.info("开始工作，工作请求参数是[{}]", params);
            //模拟工作
            Thread.sleep(1_000);
            result.put("status", 200);
            result.put("msg", "work service success");
        } catch (Exception e) {
            log.error("工作异常，异常信息：", e);
        }
        return result;
    }
}
