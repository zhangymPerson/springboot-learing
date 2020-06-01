package cn.danao.bean;

/**
 * date 2020/4/23 14:12 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public enum RuleType {

    ONE(1, "规则1", "备注"),
    TWO(2, "规则2", "备注"),
    THREE(3, "规则3", "备注"),
    FORE(4, "规则4", "备注"),
    FIVE(5, "规则5", "备注");

    /**
     * 编号
     */
    private Integer id;
    /**
     * 类型
     */
    private String type;
    /**
     * 说明
     */
    private String remark;

    RuleType(Integer id, String type, String remark) {
        this.id = id;
        this.type = type;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getRemark() {
        return remark;
    }
}
