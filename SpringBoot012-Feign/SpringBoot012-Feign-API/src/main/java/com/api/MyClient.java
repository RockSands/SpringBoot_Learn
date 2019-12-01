package com.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 非Ribbon
 * @FeignClient(name = "api", url = "http://192.168.80.138:8081/feign/api")
 */
@FeignClient(value = "feign-api-url", path = "/feign/api", fallback = MyClientFallback.class)
public interface MyClient {

	@RequestMapping(value = "/c1/m1", method = RequestMethod.GET)
	String method1(@RequestParam("p1") String p1);

	@RequestMapping(value = "/get0/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") String id);
	
	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public String get1(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth);
}
