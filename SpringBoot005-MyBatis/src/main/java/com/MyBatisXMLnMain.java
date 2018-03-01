package com;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xml.domain.Employ;
import com.xml.mapper.EmployMapper;

/**
 * @MapperScan 指定Mapper
 * 
 *             该Main使用注释的方式
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.xml")
@MapperScan("com.xml")
public class MyBatisXMLnMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyBatisXMLnMain.class, args);
		EmployMapper mapper = context.getBean(EmployMapper.class);
		Employ employ = new Employ();
		employ.setBirthDate(new Date());
		employ.setEmpNo(1001L);
		employ.setFirstName("chen");
		employ.setLastName("kuiwu");
		employ.setHireDate(new Date());
		employ.setGender("M");
		mapper.insert(employ);
		System.out.println("=ADD=>SUCCESS!");
		employ = mapper.getOne(10001L);
		// 查询一个
		System.out.println("=QUERYONE=>" + employ.getFirstName() + employ.getLastName());
		// 更新
		mapper.update("Chen", "KW", 1001L);
		System.out.println("=UPDATE=>SUCCESS!");
		// 查询所有
		List<Employ> employs = mapper.getAll("M", "Ch");
		System.out.println("=QUERYALL=>" + employs.size());
		// 删除
		mapper.delete(1001L);
		System.out.println("=DEL=>SUCCESS!");
	}

}
