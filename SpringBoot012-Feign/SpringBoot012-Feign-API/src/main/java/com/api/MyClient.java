package com.api;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api", url = "http://localhost:8080/feign/api")
public interface MyClient {
	
	@RequestMapping(value = "/c1/m1", method = RequestMethod.GET)
	String method1(@RequestParam("p1") String p1);

	@RequestMapping(value = "/get0/{id}", method = RequestMethod.GET)
	String findById(@PathVariable("id") Long id);

	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	String get1(@RequestParam("id") Long id, @RequestParam("name") String name);

}
