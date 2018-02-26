package com;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdbc.domain.Employee;
import com.jdbc.domain.Employee2;
import com.jdbc.service.EmployeeService;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.config", "com.jdbc" })
public class JdbcMain {
    public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(JdbcMain.class, args);
	EmployeeService service = context.getBean(EmployeeService.class);
	// Employee employee = new Employee();
	// employee.setBirthDate(new Date());
	// employee.setEmpNo(1001L);
	// employee.setFirstName("chen");
	// employee.setLastName("kuiwu");
	// employee.setHireDate(new Date());
	// employee.setGender("M");
	// service.primaryAdd(employee);
	// System.out.println("=ADD=>SUCCESS!");
	// employee = service.primaryQueryByNo(1001L);
	// System.out.println("=QUERYONE=>" + employee.getFirstName() +
	// employee.getLastName());
	// List<Employee> employees= service.primaryQueryAll();
	// System.out.println("=QUERYALL=>" + employees.size());
	// service.primaryDelete(1001L);
	// System.out.println("=DEL=>SUCCESS!");

	/**
	 * 数据源2
	 */
	Employee2 employee = new Employee2();
	employee.setBorn(new Date());
	employee.setEmpID(1001L);
	employee.setFirstName("chen");
	employee.setLastName("kuiwu");
	employee.setDeptID("D-1001");
	service.secondaryAdd(employee);
	System.out.println("=ADD=>SUCCESS!");
	employee = service.secondaryQueryByNo(1001L);
	System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
	List<Employee2> employees = service.secondaryQueryAll();
	System.out.println("=QUERYALL=>" + employees.size());
	service.secondaryDelete(1001L);
	System.out.println("=DEL=>SUCCESS!");
    }
}
