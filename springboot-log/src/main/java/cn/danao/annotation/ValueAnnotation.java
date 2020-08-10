package cn.danao.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * date 2020/8/10 16:11 <br/>
 * description class <br/>
 * 字符自定义注解
 * 判断参数是否合法的注解
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
// 指定注解的处理类
@Constraint(validatedBy = ValueAnnotationHandler.class)
public @interface ValueAnnotation {

    /**
     * 注解的配置，用 ","分割，如果参数配置则返回正确，否则返回错误
     *
     * @return
     */
    String value() default "";

    String defaultValue() default "默认值";

    /**
     * 下面三项必需约定
     *
     * @return
     */
    String message() default "自定义注解默认错误信息提示";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
