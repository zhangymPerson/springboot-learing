package cn.danao.annotation;

import java.lang.annotation.*;

/**
 * @author danao
 * @version 1.0
 * @classname TestNote
 * @descriptionclass
 * 1.测试注解
 * 2.自定义注解
 *
 * 说明 下面三个是元注解
 * 指定注解使用的位置 类  方法 属性 ...
 * @Target(ElementType.METHOD)
 * 指定注解的存活时间
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 *
 *
 * 注解使用方式：@注解类名(key = value,•••)
 *
 * 注解的获取方式 反射
 *
 * Class class = Class.forName("");
 *
 *类名为注解使用类 如果是方法需要遍历类对象
 *
 * @createdate 2019/6/26 18:15
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestNote {

    /**
     * 说明
     * 成员类型受限
     *
     * 基本类型 和 String
     *只有一个成员，则成员必须命名为 value
     *
     * 没有成员的注解是标识
     */

    /**
     * 成员定义无参无异常定义
     * @return
     */
    String test() default "test";

    /**
     * 注解中的参数可以设置默认值
     * @return
     */
    //int num() default 20;

}
