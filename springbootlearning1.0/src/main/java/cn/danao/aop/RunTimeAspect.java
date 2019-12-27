package cn.danao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * date 2019/12/27 11:27 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Component
@Aspect
@Slf4j
public class RunTimeAspect {


    /**
     * 测试注解切面
     *
     * @param joinPoint 切入方法
     */
    @Before("@annotation(cn.danao.aop.RunTime)")
    public void logAnnotation(final JoinPoint joinPoint) {
        try {
            log.info("--------------------------注解成功--------------------");
            log.info("joinPoint [{}]", joinPoint);
            log.info("--------------------------注解成功--------------------");
        } catch (Exception e) {
            log.error("测试注解切面异常[{}]", e);
            e.printStackTrace();
        }
    }

}
