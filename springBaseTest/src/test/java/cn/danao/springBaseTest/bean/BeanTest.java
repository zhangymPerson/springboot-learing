package cn.danao.springBaseTest.bean;

import cn.danao.springBaseTest.SpringBaseTestApplicationTests;
import cn.danao.springBaseTest.bean.single.SingleModel;
import cn.danao.springBaseTest.bean.single.SingleModelContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * date 2020/8/12 16:20 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class BeanTest extends SpringBaseTestApplicationTests {
    @Autowired
    private SingleModel singleModel;

    @Autowired
    private SingleModelContext singleModelContext;

    @Test
    public void test() {
        long a = GraphLayout.parseInstance(singleModel).totalSize();
        singleModel.setId("234");
        long b = GraphLayout.parseInstance(singleModel).totalSize();
        singleModel.setName("测试askdfk;lasfjlkasjdlkfjlksjdalkfjlajsdlkfjlassjdldfjlkasdlfkjalksdflaksjdfkl");
        long c = GraphLayout.parseInstance(singleModel).totalSize();
        //对象内部信息
        log.info(ClassLayout.parseInstance(singleModel).toPrintable());
        //对象外部信息
        log.info(GraphLayout.parseInstance(singleModel).toPrintable());
        log.info("\na={},\nb={},\nc={}", a, b, c);
    }


    public void setSingleModel() {
        //自动注入对象，如果是重新指向新对象，则spring容器中的单例对象不变，只在当前类中修改
        //如果不进行 new Object(); 操作，则其他spring容器中的单例对象随之一起修改，其他自动注入的类也受影响
        // singleModel = new SingleModel();
        singleModel.setName("zhangsan");
        singleModel.setId("set");
    }

    public void getSingleModel() {
        log.info("自动注入的类:singleModel = {}", singleModel);
    }

    @Test
    public void testModel() {
        singleModelContext.test();
        getSingleModel();
        setSingleModel();
        getSingleModel();
        singleModelContext.test();
    }
}



