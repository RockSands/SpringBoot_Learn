package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceList {
	
	@Autowired
	private List<BaseService> serviceList;
	
	public void excute() {
		for(BaseService service : serviceList) {
			service.excute();
		}
	}
}
