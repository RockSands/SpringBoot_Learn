package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.domain.Employee;
import com.mybatis.mapper.EmplyeeMapper;

/**
 *
 */
@Service
public class EmplyeeService {
    @Autowired
    private EmplyeeMapper emplyeeMapper;

    public List<Employee> getAll(String gender, String firstName) {
	return emplyeeMapper.getAll(gender, firstName);
    }

    public Employee getOne(Long empNo) {
	return emplyeeMapper.getOne(empNo);
    }

    public void insert(Employee employee) {
	emplyeeMapper.insert(employee);
    }

    public void update(String firstname, String lastName, Long empNo) {
	emplyeeMapper.update(firstname, lastName, empNo);
    }

    public void delete(Long empNo) {
	emplyeeMapper.delete(empNo);
    }
}
