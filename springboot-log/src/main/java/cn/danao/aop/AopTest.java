package cn.danao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author danao
 * @version 1.0
 * @classname AopTest
 * @descriptionclass 1.SpringAop 测试使用
 * 2.其他说明
 * @createdate 2019/6/27 11:12
 * @since 1.0
 */
@Aspect
@Slf4j
@Component
public class AopTest {

    /*    *//*@PointCut注解表示表示横切点，哪些方法需要被横切*//*
     *//*切点表达式*//*
    @Pointcut("execution(public * cn.danao.controller.*.*(..))")
    *//*切点签名*//*
    public void print() {
        //只做标识,代表切入点位置的方法执行的位置
        //方法名代表切点的别名
        //与@Before和@After注解一起使用
    }

    *//*@Before注解表示在具体的方法之前执行*//*
    @Before("print()")
    public void before(JoinPoint joinPoint) {
        log.info("前置切面before……");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();   //这个方法取客户端ip"不够好"
        String requestMethod = request.getMethod();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("请求url=" + requestURI + ",客户端ip=" + remoteAddr + ",请求方式=" + requestMethod + ",请求的类名=" + declaringTypeName + ",方法名=" + methodName + ",入参=" + args);
    }

    *//*@After注解表示在方法执行之后执行*//*
    @After("print()")
    public void after() {
        log.info("后置切面after……");
    }

    *//*@AfterReturning注解用于获取方法的返回值*//*
    @AfterReturning(pointcut = "print()", returning = "object")
    public void getAfterReturn(Object object) {
        log.info("本次接口耗时={}ms", "1000");
        if (object != null) {

            log.info("afterReturning={}", object.toString());
        }
    }*/

}
