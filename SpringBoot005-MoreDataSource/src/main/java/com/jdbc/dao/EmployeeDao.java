package com.jdbc.dao;

import java.util.List;

import com.jdbc.domain.Employee;
import com.jdbc.domain.Employee2;

public interface EmployeeDao {
    /**
     * 新增一个用户
     */
    void primaryAdd(Employee employee);

    /**
     * 删除
     */
    void primaryDelete(long empNo);

    /**
     * 查询所有
     */
    List<Employee> primaryQueryAll();
    
    /**
     * 查询一个
     */
    Employee primaryQueryByNo(long empNo);
    
    /**
     * 新增一个用户
     */
    void secondaryAdd(Employee2 employee);

    /**
     * 删除
     */
    void secondaryDelete(long empNo);

    /**
     * 查询所有
     */
    List<Employee2> secondaryQueryAll();
    
    /**
     * 查询一个
     */
    Employee2 secondaryQueryByNo(long empNo);
}
