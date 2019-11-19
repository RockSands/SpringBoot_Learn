package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class MyController {
	
	@RequestMapping(value = "/c1/m1", method = RequestMethod.GET)
	public String method1(@RequestParam("p1") String p1) {
		return "method1: " + p1;

	}

	@RequestMapping(value = "/get0/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") Long id) {
		return "findById: " + id;
	}

	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public String get1(@RequestParam("id") Long id, @RequestParam("name") String name) {
		return "get1: " + id + " - " + name;
	}
}