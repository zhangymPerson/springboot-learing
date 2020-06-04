package cn.danao.bean.strinfo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date 2020/6/4 15:55 <br/>
 * description class <br/>
 * 测试多层bean对象 在 drools excel规则中的使用
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class A {
    public A(int id) {
        init(id);
    }

    private int id;

    private String name;

    private List<String> stringList;

    private B b;

    private Map<String, String> map;

    private void init(int id) {
        this.id = id;
        this.name = "AName" + id;
        this.b = new B(id);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < id; i++) {
            strings.add(String.valueOf(i));
        }
        this.stringList = strings;
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("id", String.valueOf(id));
        this.map = stringMap;
    }

}
