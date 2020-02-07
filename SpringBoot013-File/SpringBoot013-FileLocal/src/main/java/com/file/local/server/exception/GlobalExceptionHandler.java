package com.file.local.server.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author chenkw
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 返回Json
	 * 
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = FileServerException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, HttpServletResponse response,
			FileServerException e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return r;
	}

	/**
	 * 处理Exception以及其子类
	 * 
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	String handleException(HttpServletResponse response,Exception e) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return "文件服务发生异常!";
	}
}
