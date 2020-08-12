package cn.danao.springBaseTest.bean.single;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * date 2020/8/12 16:18 <br/>
 * description class <br/>
 * 单例对象
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Component
@Data
public class SingleModel {
    private String id;
    private String name;
}
