package cn.danao.api.server.impl;

import cn.danao.api.server.HelloService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/3/15 8:44 <br/>
 * descriptionclass <br/>
 * 服务实现类
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

    public String sayHello(String word) {
        log.info("提供者远程服务的实现，请求参数 [{}]", word);
        return "hello " + word;
    }

    public Map<String, Object> getInfo(Map<String, Object> params) {
        log.info("提供者远程服务的实现，请求参数如下: \n [{}] \n", params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", "");
        result.put("msg", "");
        result.put("request", params);
        result.put("result", "");
        return result;
    }
}
