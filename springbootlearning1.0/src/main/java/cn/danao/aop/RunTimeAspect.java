package cn.danao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

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
     * 切入接口时，只能切入接口中定义的方法，接口未定义的方法未切入
     *
     * @param joinPoint 切入方法
     */
    @Before("@annotation(cn.danao.aop.RunTime)")
    public void aspectAnnotation(final JoinPoint joinPoint) {
        try {
            log.info("--------------------------注解成功--------------------");
            log.info("joinPoint [{}]", joinPoint);
            RunTime runTime = getDeclaredAnnotation(joinPoint);
            log.info("runTime={}", runTime.desc());
            log.info("--------------------------注解成功--------------------");
        } catch (Exception e) {
            log.error("测试注解切面异常[{}]", e);
            e.printStackTrace();
        }
    }


    /**
     * 获取方法中声明的注解
     *
     * @param joinPoint 切入点
     * @return 自定义注解
     * @throws NoSuchMethodException 异常
     */
    private RunTime getDeclaredAnnotation(JoinPoint joinPoint) throws NoSuchMethodException {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 反射获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型（重载）获取到方法的具体信息
        Method objMethod = targetClass.getMethod(methodName, parameterTypes);
        // 拿到方法定义的注解信息
        // 返回
        return objMethod.getDeclaredAnnotation(RunTime.class);
    }

    /**
     * 统计Service中方法调用的时间
     *
     * @param joinPoint 切入点
     * @throws Throwable 异常
     */
    @Around("@annotation(cn.danao.aop.RunTime)")
    public Object logServiceMethodAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        RunTime runTime = getDeclaredAnnotation(joinPoint);
        StopWatch stopWatch = new StopWatch(runTime.desc());
        stopWatch.start();
        Object object = joinPoint.proceed();
        stopWatch.stop();
        String tmp = joinPoint.getSignature().toString();
        log.info("{},\n{}", tmp, stopWatch.prettyPrint());
        return object;
    }
}
