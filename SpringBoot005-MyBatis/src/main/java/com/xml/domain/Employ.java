package com.xml.domain;

import java.util.Date;

/**
 * JPA的实体类
 * 
 * @author Administrator
 *
 */
public class Employ {
	/**
	 * 员工编号
	 */
	private Long empNo;

	/**
	 * 出生日期
	 */
	private Date birthDate;

	/**
	 * 姓
	 */
	private String firstName;

	/**
	 * 名
	 */
	private String lastName;

	/**
	 * 雇佣日期
	 */
	private Date hireDate;

	/**
	 * 岗位
	 */
	private String gender;

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
