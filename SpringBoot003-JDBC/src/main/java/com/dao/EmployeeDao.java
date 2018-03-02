package com.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.domain.Employee;

public interface EmployeeDao {
    /**
     * 新增一个用户
     */
    void add(Employee employee);

    /**
     * 删除
     */
    void delete(long empNo);

    /**
     * 查询所有
     */
    List<Employee> queryAll();
    
    /**
     * 查询一个
     */
    Employee queryByNo(long empNo);
}
