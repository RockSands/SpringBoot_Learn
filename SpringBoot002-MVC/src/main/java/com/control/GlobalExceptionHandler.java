package com.control;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exception.MyException;

/**
 * 使用@ControllerAdvice + @ExceptionHandler 完成对每个@Controller的异常处理
 * 
 * @author Administrator
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 处理Exception以及其子类
	 * 
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	String handleException(Exception e) {
		System.out.println("=0=>" + e.getMessage());
		return "Exception Deal!";
	}
	
	@ExceptionHandler()
	@ResponseBody
	String handleException(MyException ex) {
		System.out.println("=01=>" + ex.getMessage());
		return ex.getMessage();
	}
}
