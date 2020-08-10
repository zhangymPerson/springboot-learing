package cn.danao.test.base;

import cn.danao.bean.vo.VarModel;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * date 2020/8/10 17:27 <br/>
 * description class <br/>
 * 参数校验测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class VarModelTest extends SpringTest {


    /**
     * {"age":12,"birthday":1597052041502,"email":"123@163.com","expire":1597052041502,"flag":true,"list":[12,32],"name":"test","pass":"pass","range":2334,"salary":344,"url":"http://baidu.com","value":"3"}
     */
    @Test
    public void test() {
        VarModel varModel = new VarModel();
        varModel.setName("test");
        varModel.setAge(12);
        varModel.setBirthday(new Date());
        varModel.setEmail("123@163.com");
        varModel.setExpire(new Date());
        varModel.setFlag(true);
        varModel.setPass("pass");
        varModel.setSalary(344);
        varModel.setUrl("http://baidu.com");
        varModel.setRange(2334);
        varModel.setValue("3");
        List<Integer> collect = Stream.of(12, 32).collect(Collectors.toList());
        varModel.setList(collect);
        log.info("{}", JSONObject.toJSONString(varModel));
    }

}
