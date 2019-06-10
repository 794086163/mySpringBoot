package com.didispace.exception;

import com.didispace.entity.ExceptionInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * @author v-yangxu
 *
 */
@ControllerAdvice
@Log4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView defaultException(HttpServletRequest req,Exception ex){
		ModelAndView model=new ModelAndView();
		model.setViewName("error");//设置视图时需要添加thymeleaf模板引擎
		model.addObject("url", req.getRequestURL().toString());
		model.addObject("message", ex.getMessage());
        log.error(model.toString());
		return model;
	}

	/**
	 * 拦截myException
	 * @param req
	 * @param ex
	 * @return
     */
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public ExceptionInfo<String> myException(HttpServletRequest req,MyException ex){
		ExceptionInfo<String> info=new ExceptionInfo<String>();
		info.setMessage(ex.getMessage());
		info.setData("看啥，你错了");
		info.setRequestUrl(req.getRequestURL().toString());
        log.error(info.toString());
		return info;
	} 
}
