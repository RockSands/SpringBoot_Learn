package com.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Employee;
import com.domain.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<Employee> findByFirstName(String name) {
	return repository.findByFirstName(name);
    }

    @Transactional(readOnly = true)
    public Employee findOne(Long id) {
	return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
	// 条件查询
	Specification<Employee> conditions = new Specification<Employee>() {
	    @Override
	    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// root对象相当于form后面的表对象
		// query对象构建where条件语句
		// CriteriaBuilder构建工具
		// 一下逻辑是查询Employee表,且Where条件为gender = 'M'
		Predicate and0 = cb.equal(root.get("gender"), "M");
		Predicate and1 = cb.like(root.get("firstName"), "K%");
		return cb.and(and0, and1);
	    }
	};
	return repository.findAll(conditions);
    }

    /**
     * 更新
     * 
     * @Modifying 标记为更新操作
     * @Transactional 表明事物
     * @Query 书写SQL
     * @return
     */
    @Transactional()
    public void addEmployee(Employee employee) {
	repository.saveAndFlush(employee);
	repository.updateEmployeeGender("F", employee.getEmpNo());
    }
    @Transactional()
    public void updateEmployeeGender(String gender,Long emp_no) {
	repository.updateEmployeeGender(gender, emp_no);
    }

    @Transactional()
    public void delete(long id) {
	repository.delete(id);
    }
}
