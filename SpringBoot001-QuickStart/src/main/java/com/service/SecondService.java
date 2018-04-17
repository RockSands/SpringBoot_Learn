package com.service;

import org.springframework.stereotype.Service;

@Service
public class SecondService extends BaseService {

	@Override
	void excute() {
		System.out.println("SecondService-->" + d);
		super.d = "SecondService";
		System.out.println("SecondService-->" + d);
	}

}
