package com.service;

import org.springframework.stereotype.Service;

@Service
public class FirstService extends BaseService {

	@Override
	void excute() {
		System.out.println("FirstService-->"+ d);
		super.d = "FirstService";
		System.out.println("FirstService-->"+ d);
	}

}
