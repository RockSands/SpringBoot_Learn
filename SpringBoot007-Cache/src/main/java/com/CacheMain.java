package com;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jpa.domain.Employee;
import com.service.EmployeeCacheService;

/**
 * @EnableCaching 开启SpringBoot缓存
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.jpa","com.service"})
@EnableCaching
public class CacheMain {

    public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(CacheMain.class, args);
	EmployeeCacheService employeeService = context.getBean(EmployeeCacheService.class);
	Employee employee = new Employee();
//	employee.setBirthDate(new Date());
//	employee.setEmpNo(1001L);
//	employee.setFirstName("chen");
//	employee.setLastName("kuiwu");
//	employee.setHireDate(new Date());
//	employee.setGender("M");
//	// 新增
//	employeeService.addEmployee(employee);
//	System.out.println("=ADD=>SUCCESS!");
	// 查询两次
	employee = employeeService.findOne(1001L);
	System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
	employee = employeeService.findOne(1001L);
	System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
    }

}
