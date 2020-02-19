package com.gjh.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//拦截所有标注有controller的控制器
public class ControllerExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)//标识这个方法可以做异常处理，Exception下的异常都可以获取
    //ModelAndView返回一个页面和信息 HttpServletRequest 获取异常的路径
    public ModelAndView exceptionHander(HttpServletRequest request,Exception e)throws Exception
    {
        logger.error("Requst url = {},Exception = {}",request.getRequestURI(),e);

        if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null)
        {
            throw e;
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("url",request.getRequestURI());
        mv.addObject("exception",e);
        mv.setViewName("error/error");//返回error这个页面
        return mv;

    }

}
