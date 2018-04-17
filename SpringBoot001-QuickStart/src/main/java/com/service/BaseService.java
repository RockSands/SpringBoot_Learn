package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.properties.Author;

public abstract class BaseService {
	
	@Autowired
	protected Author author;
	
	abstract void excute();
}
