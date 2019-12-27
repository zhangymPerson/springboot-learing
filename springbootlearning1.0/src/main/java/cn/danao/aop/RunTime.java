package cn.danao.aop;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Documented

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunTime {
    /**
     * 方法描述
     *
     * @return 描述
     */
    String desc() default "RunTime default desc";

}
