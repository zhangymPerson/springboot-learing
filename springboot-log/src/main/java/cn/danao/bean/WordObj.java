package cn.danao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * date 2020/4/23 14:18 <br/>
 * descriptionclass <br/>
 * 要处理的内容
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class WordObj {

    /**
     * 处理的key id
     */
    private String id;
    /**
     * string类型
     */
    private String key;
    /**
     * list类型
     */
    private List<String> list;

    /**
     * map类型
     */
    private Map<String, Object> map;

    /**
     * 指定规则
     */
    private RuleType ruleType;

    @Override
    public String toString() {
        return "WordObj{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", list=" + list +
                ", map=" + map +
                ", ruleType=" + ruleType +
                '}';
    }
}
