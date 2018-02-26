package com.jdbc.domain;

import java.util.Date;

/**
 * JPA的实体类
 * 
 * @author Administrator
 *
 */
public class Employee2 {
    /**
     * 员工编号
     */
    private Long empID;

    /**
     * 出生日期
     */
    private Date born;

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    /**
     * 工作编号
     */
    private String deptID;

    public Long getEmpID() {
	return empID;
    }

    public void setEmpID(Long empID) {
	this.empID = empID;
    }

    public Date getBorn() {
	return born;
    }

    public void setBorn(Date born) {
	this.born = born;
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

    public String getDeptID() {
	return deptID;
    }

    public void setDeptID(String deptID) {
	this.deptID = deptID;
    }
}
