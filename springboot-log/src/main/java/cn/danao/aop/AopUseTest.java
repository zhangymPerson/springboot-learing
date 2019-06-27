package cn.danao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author danao
 * @version 1.0
 * @classname AopTest
 * @descriptionclass 1.SpringAop 测试使用
 * 2.其他说明
 * 添加切面类后无数据返回
 * @createdate 2019/6/27 11:12
 * @since 1.0
 */
@Aspect
@Slf4j
@Component
public class AopUseTest {
/*
    @Pointcut("execution(public * cn.danao.controller.*.*(..))")
    public void recordLog(){}

    @Before("recordLog()")
    public void before() {
        printLog("已经记录下操作日志@Before 方法执行前");
    }

    *//**
     * 该注解导致数据无法返回
     * 可以直接配置切入点
     * @param pjp
     * @throws Throwable
     *//*
     *//*
    @Around("recordLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        printLog("已经记录下操作日志@Around 方法执行前");
        pjp.proceed();
        printLog("已经记录下操作日志@Around 方法执行后");
    }
    *//*

     *//**
     * 使用@Aroud注解时，如果注解对象有返回值，则该方法必须有返回值，否则拦截后无返回值
     * @param pjp
     * @return
     * @throws Throwable
     *//*
    @Around("recordLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        printLog("已经记录下操作日志@Around 方法执行前");
        Object result = pjp.proceed(pjp.getArgs());
        printLog("已经记录下操作日志@Around 方法执行后");
        return result;
    }



    @After("recordLog()")
    public void after() {
        printLog("已经记录下操作日志@After 方法执行后");
    }

    private void printLog(String str){
        log.info(str);
    }*/


}
