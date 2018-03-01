package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.Employee;

/**
 *
 */
public interface EmplyeeMapper {
	@Select("SELECT * FROM employees WHERE gender = #{gender} AND first_name LIKE '#{firstName}%'")
	@Results({ @Result(property = "empNo", column = "emp_no", javaType = Long.class),
			@Result(property = "birthDate", column = "birth_date"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"), 
			@Result(property = "gender", column = "gender"),
			@Result(property = "hireDate", column = "hire_date") })
	List<Employee> getAll(String gender, String firstName);

	@Select("SELECT * FROM employees WHERE emp_no = #{empNo}")
	@Results({ @Result(property = "empNo", column = "emp_no", javaType = Long.class),
			@Result(property = "birthDate", column = "birth_date"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "gender", column = "gender"),
			@Result(property = "hireDate", column = "hire_date") })
	Employee getOne(Long empNo);

	@Insert("INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES(#{empNo}, #{birthDate}, #{firstName},#{lastName},#{gender},#{hireDate})")
	void insert(Employee employee);

	@Update("UPDATE employees SET first_name=#{firstName},last_name=#{lastName} WHERE emp_no =#{empNo}")
	void update(Employee employee);

	@Delete("DELETE FROM employees WHERE emp_no =#{empNo}")
	void delete(Long empNo);
}
