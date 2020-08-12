package cn.danao.springBaseTest.bean.single;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * date 2020/8/12 17:13 <br/>
 * description class <br/>
 * 容器自动注入一个singleModel
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Component
@Slf4j
public class SingleModelContext {
    @Autowired
    private SingleModel singleModel;

    public void test() {
        log.info("SingleModelContext容器中的对象是[{}]", singleModel);
    }
}
