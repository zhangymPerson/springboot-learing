package cn.danao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * date 2019/12/26 10:31 <br/>
 * descriptionclass <br/>
 * <p>
 * 使用切面进行访问统计
 * <p>
 * 使用@Aspect注解将一个java类定义为切面类
 * <p>
 * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
 * <p>
 * 根据需要在切入点不同位置的切入内容
 * <p>
 * 使用@Before在切入点开始处切入内容
 * <p>
 * 使用@After在切入点结尾处切入内容
 * <p>
 * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
 * <p>
 * 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 * <p>
 * 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Aspect
@Component
@Slf4j
public class HealthStatistics {

    @Pointcut("execution(public * cn.danao.controller.*.*(..))")
    public void pointMent() {

    }

    @Before(value = "pointMent()")
    public void beforeMethod() {
        log.info("切面执行前切入");
    }

    @After(value = "pointMent()")
    public void afterMethod() {
        log.info("切面执行前切入");
    }

    /**
     * 统计API接口调用耗时（方法调用的时间）
     *
     * @param joinPoint 切入点
     * @throws Throwable 异常抛出
     */
    @Around("execution(public * cn.danao.controller.*.*(..))")
    public Object logServiceMethodAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        long start = System.currentTimeMillis();
        //切面必须调用proceed方法，否则不执行切入方法
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long takeTime = end - start;
        String className = joinPoint.getSignature().toString();
        //接口监控保存
        log.info("监控到的信息 {} {} {} {}", request.getRequestURL().toString(), request.getMethod(), className, takeTime);
        //必须返回切入对象
        return object;
    }

}
