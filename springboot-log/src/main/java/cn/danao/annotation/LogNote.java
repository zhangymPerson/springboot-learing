package cn.danao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author danao
 * @version 1.0
 * @classname LogNote
 * @descriptionclass
 * 1.日志注解
 * 2.其他说明
 * @createdate 2019/6/26 17:43
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogNote {
    /**
     * 类信息
     * @return
     */
    Class cla();

    /**
     * 日志说明
     * @return
     */
    String value();

    /**
     * 日志信息
     * @return
     */
    String info();
}
