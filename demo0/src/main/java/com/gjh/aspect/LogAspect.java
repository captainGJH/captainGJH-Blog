package com.gjh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    private  final  static Logger logger= LoggerFactory.getLogger(LogAspect.class);
@Pointcut("execution(* com.gjh.controller.*.*(..))")//切面所拦截的位置 .*.*(..)表示所有类的所以方法
	public void log()
{


}
//日志
@Before("log()")//请求方法返回之前都会执行下面的方法
	public void logbefore(JoinPoint joinPoint)
{
    ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request=attributes.getRequest();
    logger.info("--------logBefore----------");
    logger.info("url={}",request.getRequestURI());
    logger.error("url={}","error"+request.getRequestURI());
    logger.debug("url={}","debug"+request.getRequestURI());
    logger.info("method={}",request.getMethod());
    logger.info("ip={}",request.getRemoteAddr());
    logger.info("classmethod={}",joinPoint.getSignature().getDeclaringTypeName()+"_"+joinPoint.getSignature().getName());
    logger.info("args={}",joinPoint.getArgs());
}
@After("log()")//请求方法返回之后都会执行下面的方法
public void logAfter()
{
    logger.info("--------logAfter----------");
}

@AfterReturning(pointcut="log()",returning="object")
	public void logAfterReturn(Object object)
{
    logger.info("response={}",object);

}
            }

