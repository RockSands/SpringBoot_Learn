package com.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exception.MyException;

@RestController
@RequestMapping(value = "exception")
public class ExceptionController {
	@RequestMapping(value = "/01", method = RequestMethod.GET)
	public void doSomething00() throws Exception {
		throw new Exception("Exception");
	}
	@RequestMapping(value = "/02", method = RequestMethod.GET)
	public void doSomething01() throws MyException {
		throw new MyException();
	}
}
