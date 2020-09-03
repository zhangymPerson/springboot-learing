package cn.danao.springboot.springbootkotlin.bean;

/**
 * date 2020/9/2 17:32 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class UserTwo {
    public String name;

    private String other;

    public UserTwo(String name, String other) {
        this.name = name;
        this.other = other;
    }

    public UserTwo() {
    }

    public String getName() {
        return name;
    }

    /**
     * 私有化的set kotlin不能赋值
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "UserTwo{" +
                "name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
