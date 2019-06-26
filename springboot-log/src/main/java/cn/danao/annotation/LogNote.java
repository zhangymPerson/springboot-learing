package cn.danao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

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
    public Date date = null;
}
