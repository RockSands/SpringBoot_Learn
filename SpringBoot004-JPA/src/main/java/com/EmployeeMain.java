package com;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import com.domain.Employee;
import com.domain.EmployeeRepository;

/**
 * 自动加载测试
 * 通过/resources/META_INFO/spring.factories,配置Spring自动读取类,并通过@Conditional相关注释达到条件自动加载
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
public class EmployeeMain {

    public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(EmployeeMain.class, args);
	EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
	Employee employee = new Employee();
	employee.setBirthDate(new Date());
	employee.setEmpNo(1001L);
	employee.setFirstName("chen");
	employee.setLastName("kuiwu");
	employee.setHireDate(new Date());
	employee.setGender("M");
	// 新增
	employeeRepository.saveAndFlush(employee);
	System.out.println("=ADD=>SUCCESS!");
	employee = employeeRepository.findOne(1001L);
	// 查询一个
	System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
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
	List<Employee> employees = employeeRepository.findAll(conditions);
	System.out.println("=QUERYALL=>" + employees.size());
	// 删除
	employeeRepository.delete(1001L);
	System.out.println("=DEL=>SUCCESS!");
    }
}
