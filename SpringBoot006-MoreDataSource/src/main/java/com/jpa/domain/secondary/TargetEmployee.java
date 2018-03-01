package com.jpa.domain.secondary;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JPA的实体类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "target_employees")
public class TargetEmployee {
    /**
     * 员工编号
     */
    @Id
    @Column(name = "empID", unique = true, nullable = false, length = 11)
    private Long empID;

    /**
     * 工作编号
     */
    @Column(name = "deptID", unique = true, nullable = false, length = 64)
    private String deptID;

    /**
     * 出生日期
     */
    @Column(name = "born")
    private Date born;

    /**
     * 姓
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * 名
     */
    @Column(name = "lastName")
    private String lastName;

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
