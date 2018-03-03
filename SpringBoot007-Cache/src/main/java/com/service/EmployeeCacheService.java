package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeRepository;

/**
 * @CacheConfig 配置缓存名称为employees
 * @Cacheable：方法的返回值将被加入缓存。同时在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问。
 * @CachePut：配置于方法并上，调用时每次都会调用方法将返回的数据写入缓存，所以主要用于数据新增和修改操作上。
 * @CacheEvict：配置于方法上，通常用在删除方法上，用来从缓存中移除相应数据。
 */
@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeCacheService {
    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    @Cacheable
    public Employee findOne(Long id) {
	System.out.println("==> cacheFineOne");
	return repository.findOne(id);
    }

    @Transactional()
    public void addEmployee(Employee employee) {
	repository.saveAndFlush(employee);
    }

    @Transactional()
    public void delete(long id) {
	repository.delete(id);
    }
}
