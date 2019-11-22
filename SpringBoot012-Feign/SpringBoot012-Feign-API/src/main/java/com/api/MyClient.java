package com.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 非Ribbon
 * @FeignClient(name = "api", url = "http://192.168.80.138:8081/feign/api")
 */
@FeignClient(value = "feign-api-url", path = "/feign/api", fallback = MyClient.MyClientFallback.class)
public interface MyClient {

	@RequestMapping(value = "/c1/m1", method = RequestMethod.GET)
	String method1(@RequestParam("p1") String p1);

	@Component
	class MyClientFallback implements MyClient {
		/**
		 * 降级统一返回无权限
		 *
		 * @param authentication
		 * @param url
		 * @param method
		 * @return
		 * 
		 *         <pre>
		 * Result:
		 * {
		 *   code:"-1"
		 *   mesg:"系统异常"
		 * }
		 *         </pre>
		 */
		@Override
		public String method1(String p1) {
			return "Feign,[" + p1 + "]执行异常";
		}
	}

}
