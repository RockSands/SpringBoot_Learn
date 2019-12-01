package com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class MyController {

	@RequestMapping(value = "/c1/m1", method = RequestMethod.GET)
	public String method1(@RequestParam("p1") String p1) {
		System.out.println("---method1--->" + p1);
		return "method1: " + p1;

	}

	@RequestMapping(value = "/get0/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") String id) {
		System.out.println("---findById--->" + id);
		return "findById: " + id;
	}

	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public String get1(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
		System.out.println("---get1--->" + auth);
		return "get1: " + auth;
	}
}