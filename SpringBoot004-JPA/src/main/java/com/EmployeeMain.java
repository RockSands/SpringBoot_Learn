package com;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.domain.Employee;
import com.service.EmployeeService;

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
	EmployeeService employeeService = context.getBean(EmployeeService.class);
	Employee employee = new Employee();
	employee.setBirthDate(new Date());
	employee.setEmpNo(1001L);
	employee.setFirstName("chen");
	employee.setLastName("kuiwu");
	employee.setHireDate(new Date());
	employee.setGender("M");
	// 新增
	employeeService.addEmployee(employee);
	System.out.println("=ADD=>SUCCESS!");
	employee = employeeService.findOne(1001L);
	// 查询一个
	System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
	
	List<Employee> employees = employeeService.findAll();
	System.out.println("=QUERYALL=>" + employees.size());
	// 删除
	employeeService.delete(1001L);
	System.out.println("=DEL=>SUCCESS!");
    }
}
