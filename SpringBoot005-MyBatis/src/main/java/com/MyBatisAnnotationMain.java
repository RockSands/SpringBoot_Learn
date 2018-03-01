package com;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.annotation.domain.Employee;
import com.annotation.mapper.EmplyeeMapper;

/**
 * @MapperScan 指定Mapper
 * 
 *             该Main使用注释的方式
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.annotation.mapper")
@MapperScan("com.annotation.mapper")
public class MyBatisAnnotationMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyBatisAnnotationMain.class, args);
		EmplyeeMapper mapper = context.getBean(EmplyeeMapper.class);
		Employee employee = new Employee();
		employee.setBirthDate(new Date());
		employee.setEmpNo(1001L);
		employee.setFirstName("chen");
		employee.setLastName("kuiwu");
		employee.setHireDate(new Date());
		employee.setGender("M");
		mapper.insert(employee);
		System.out.println("=ADD=>SUCCESS!");
		employee = mapper.getOne(10001L);
		// 查询一个
		System.out.println("=QUERYONE=>" + employee.getFirstName() + employee.getLastName());
		// 更新
		mapper.update("Chen", "KW", 1001L);
		System.out.println("=UPDATE=>SUCCESS!");
		// 查询所有
		List<Employee> employees = mapper.getAll("M", "Chen%");
		System.out.println("=QUERYALL=>" + employees.size());
		// 删除
		mapper.delete(1001L);
		System.out.println("=DEL=>SUCCESS!");
	}

}
