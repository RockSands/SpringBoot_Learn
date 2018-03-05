package com.jpa.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 只需要接口声明,Dao会自动实现JpaRepository内部提供的功能. 开发者只需要在接口里面定义自己的方法.
 * JpaRepository：提供基础的增删改查、翻页以及默认的Jpql语法方法-->适合简单逻辑
 * JpaSpecificationExecutor：提供Specification接口的支持-->适合复杂逻辑
 * 
 * @author Administrator
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	/*
	 * 自定义 ?1 位传参第一个值, ?2 为第二个值 nativeQuery = true value内为sql语法, 默认为jpql语法
	 */
	@Query(value = "SELECT * FROM EMPLOYEES WHERE first_name = ?1", nativeQuery = true)
	public List<Employee> queryByName(String name);
}
