package cn.danao.bean;

import lombok.Data;

/**
 * date 2020/6/1 14:26 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class User {
    /**
     * 编号
     */
    public String id;
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
    public int age;

    /**
     * 备注
     */
    public String remark;
}
