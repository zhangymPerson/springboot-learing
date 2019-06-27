package cn.danao.aop;

import cn.danao.annotation.LogNote;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author danao
 * @version 1.0
 * @classname LogAopTest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/27 15:17
 * @since 1.0
 */
@Slf4j
@Component
@Aspect
public class LogAopTest {

    @Around("execution(* cn.danao.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        log.info("已经记录下操作日志@Around 方法执行前");
        Object[] objs = pjp.getArgs();
        //获取拦截到的方法的签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        if(methodSignature == null){
            //可能获取到接口的方法，此处可能为空
        }else {
            Method method  = methodSignature.getMethod();
            LogNote logNote = method.getAnnotation(LogNote.class);
            String date = new Date().toString();
            String className = "";
            String value = "";
            String info = "";
            if(logNote != null){
                className = logNote.cla().getName();
                value = logNote.value();
                info = logNote.info();
            }
            log.info("{} 调用的 类{} 方法{} value {} info {}",date,className,methodSignature.getMethod().getName(),value,info);

        }
        log.info("获取到的对象:{}",objs);
        Object result = pjp.proceed(pjp.getArgs());
        log.info("已经记录下操作日志@Around 方法执行后");
        return result;
    }
}
