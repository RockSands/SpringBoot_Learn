package com;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mybatis.domain.TargetEmployee;
import com.mybatis.mapper.TargetEmployeeMapper;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
	JpaRepositoriesAutoConfiguration.class })
@ComponentScan("com.mybatis")
public class MybatisMain {

    public static void main(String[] args) {

	ConfigurableApplicationContext context = SpringApplication.run(MybatisMain.class, args);
	/**
	 * 数据源Primary
	 */
	// EmplyeeService mapper = context.getBean(EmplyeeService.class);
	// Employee employee = new Employee();
	// employee.setBirthDate(new Date());
	// employee.setEmpNo(1001L);
	// employee.setFirstName("chen");
	// employee.setLastName("kuiwu");
	// employee.setHireDate(new Date());
	// employee.setGender("M");
	// mapper.insert(employee);
	// System.out.println("=ADD=>SUCCESS!");
	// employee = mapper.getOne(10001L);
	// // 查询一个
	// System.out.println("=QUERYONE=>" + employee.getFirstName() +
	// employee.getLastName());
	// // 更新
	// mapper.update("Chen", "KW", 1001L);
	// System.out.println("=UPDATE=>SUCCESS!");
	// // 查询所有
	// List<Employee> employees = mapper.getAll("M", "Chen%");
	// System.out.println("=QUERYALL=>" + employees.size());
	// // 删除
	// mapper.delete(1001L);
	// System.out.println("=DEL=>SUCCESS!");
	/**
	 * 数据源Secondary
	 */
	TargetEmployeeMapper targetEmployeeMapper = context.getBean(TargetEmployeeMapper.class);
	TargetEmployee targetEmployee = new TargetEmployee();
	targetEmployee.setBorn(new Date());
	targetEmployee.setEmpID(1001L);
	targetEmployee.setFirstName("chen");
	targetEmployee.setLastName("kuiwu");
	targetEmployee.setDeptID("D-1001");
	// 新增
	targetEmployeeMapper.insert(targetEmployee);
	System.out.println("=ADD=>SUCCESS!");
	targetEmployee = targetEmployeeMapper.getOne(1001L);
	// 查询一个
	System.out.println("=QUERYONE=>" + targetEmployee.getFirstName() + targetEmployee.getLastName());
	List<TargetEmployee> targetEmployees = targetEmployeeMapper.getAll("Ch%");
	System.out.println("=QUERYALL=>" + targetEmployees.size());
	// 删除
	targetEmployeeMapper.delete(1001L);
	System.out.println("=DEL=>SUCCESS!");
    }

}
