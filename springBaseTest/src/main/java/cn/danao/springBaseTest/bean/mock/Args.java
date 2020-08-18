package cn.danao.springBaseTest.bean.mock;

/**
 * date 2020/8/18 10:15 <br/>
 * description class <br/>
 * mock 测试对象
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class Args {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex(Integer sex) {
        if (sex == 1) {
            return "man";
        } else {
            return "woman";
        }
    }
}
