package com;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;

import com.jpa.domain.primary.Employee;
import com.jpa.domain.primary.EmployeeRepository;
import com.jpa.domain.secondary.TargetEmployee;
import com.jpa.domain.secondary.TargetEmployeeRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.config", "com.jpa" })
public class JpaMain {

    public static void main(String[] args) {

	ConfigurableApplicationContext context = SpringApplication.run(JpaMain.class, args);
	/**
	 * 数据源Primary
	 */
//	EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//	Employee employee = new Employee();
//	employee.setBirthDate(new Date());
//	employee.setEmpNo(1001L);
//	employee.setFirstName("chen");
//	employee.setLastName("kuiwu");
//	employee.setHireDate(new Date());
//	employee.setGender("M");
//	// 新增
//	employeeRepository.saveAndFlush(employee);
//	System.out.println("=ADD=>SUCCESS!");
//	employee = employeeRepository.findOne(1001L);
//	// 查询一个
//	System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
//	// 条件查询
//	Specification<Employee> conditions = new Specification<Employee>() {
//	    @Override
//	    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//		// root对象相当于form后面的表对象
//		// query对象构建where条件语句
//		// CriteriaBuilder构建工具
//		// 一下逻辑是查询Employee表,且Where条件为gender = 'M'
//		Predicate and0 = cb.equal(root.get("gender"), "M");
//		Predicate and1 = cb.like(root.get("firstName"), "K%");
//		return cb.and(and0, and1);
//	    }
//	};
//	List<Employee> employees = employeeRepository.findAll(conditions);
//	System.out.println("=QUERYALL=>" + employees.size());
//	// 删除
//	employeeRepository.delete(1001L);
//	System.out.println("=DEL=>SUCCESS!");
	/**
	 * 数据源Secondary
	 */
	TargetEmployeeRepository targetEmployeeRepository = context.getBean(TargetEmployeeRepository.class);
	TargetEmployee targetEmployee = new TargetEmployee();
	targetEmployee.setBorn(new Date());
	targetEmployee.setEmpID(1001L);
	targetEmployee.setFirstName("chen");
	targetEmployee.setLastName("kuiwu");
	targetEmployee.setDeptID("D-1001");
	// 新增
	targetEmployeeRepository.saveAndFlush(targetEmployee);
	System.out.println("=ADD=>SUCCESS!");
	targetEmployee = targetEmployeeRepository.findOne(1001L);
	// 查询一个
	System.out.println("=QUERYONE=>" + targetEmployee.getFirstName() + targetEmployee.getLastName());
	List<TargetEmployee> targetEmployees = targetEmployeeRepository.findAll();
	System.out.println("=QUERYALL=>" + targetEmployees.size());
	// 删除
	targetEmployeeRepository.delete(1001L);
	System.out.println("=DEL=>SUCCESS!");
    }

}
