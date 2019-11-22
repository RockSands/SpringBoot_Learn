package com.api;

import org.springframework.stereotype.Component;

@Component
public class MyClientFallback implements MyClient {
	
	@Override
	public String method1(String p1) {
		return "Feign,[" + p1 + "]执行异常";
	}

}
