package com.api;

import org.springframework.stereotype.Component;

@Component
public class MyClientFallback implements MyClient {
	
	@Override
	public String method1(String p1) {
		return "Feign,[" + p1 + "]执行异常";
	}

	@Override
	public String findById(String id) {
		return "Feign,[" + id + "]执行异常";
	}

	@Override
	public String get1(String auth) {
		return "Feign,[" + auth + "]执行异常";
	}

}
