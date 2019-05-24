package cn.danao.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author danao
 * @version 1.0
 * @classname UserInfo
 * @descriptionclass
 * 1.测试实体类
 * 2.其他说明
 * @createdate 2019/5/24 15:27
 * @since 1.0
 */
@ComponentScan
public class UserInfo {

    /**
     * 编号
     */
    private int id;

    /**
     * 姓名
     */
    private String name ;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 备注
     */
    private String remark;

    public UserInfo(String name, Integer age, String sex, String remark) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.remark = remark;
    }

    public UserInfo(int id, String name, Integer age, String sex, String remark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
