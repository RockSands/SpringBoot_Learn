package com.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.domain.Employee;
import com.jdbc.domain.Employee2;

@Service
public class EmployeeService implements EmployeeDao {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    /**
     * Employee的对象Mapper
     */
    private static final RowMapper<Employee> primaryRowMapper = new RowMapper<Employee>() {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Employee employee = new Employee();
	    employee.setEmpNo(rs.getLong("emp_no"));
	    employee.setBirthDate(rs.getDate("birth_date"));
	    employee.setFirstName(rs.getString("first_name"));
	    employee.setLastName(rs.getString("last_name"));
	    employee.setGender(rs.getString("gender"));
	    employee.setHireDate(rs.getDate("hire_date"));
	    return employee;
	}
    };

    private static final RowMapper<Employee2> secondaryRowMapper = new RowMapper<Employee2>() {

	@Override
	public Employee2 mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Employee2 employee = new Employee2();
	    employee.setEmpID(rs.getLong("empID"));
	    employee.setBorn(rs.getDate("born"));
	    employee.setFirstName(rs.getString("firstName"));
	    employee.setLastName(rs.getString("lastName"));
	    employee.setDeptID(rs.getString("deptID"));
	    return employee;
	}
    };

    @Override
    public void primaryAdd(Employee employee) {
	primaryJdbcTemplate.update(
		"INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?)",
		employee.getEmpNo(), employee.getBirthDate(), employee.getFirstName(), employee.getLastName(),
		employee.getGender(), employee.getHireDate());
    }

    @Override
    public void primaryDelete(long empNo) {
	primaryJdbcTemplate.update("DELETE FROM employees WHERE emp_no= ?", empNo);
    }

    @Override
    public List<Employee> primaryQueryAll() {
	return primaryJdbcTemplate.query("SELECT * FROM employees WHERE gender = 'M' AND first_name LIKE 'K%'",
		primaryRowMapper);
    }

    @Override
    public Employee primaryQueryByNo(long empNo) {
	return primaryJdbcTemplate.queryForObject("SELECT * FROM employees WHERE emp_no = ?", new Object[] { empNo },
		primaryRowMapper);
    }

    @Override
    public void secondaryAdd(Employee2 employee) {
	secondaryJdbcTemplate.update(
		"INSERT INTO target_employees (empID, deptID, firstName, lastName, born) VALUES (?, ?, ?, ?, ?)",
		employee.getEmpID(), employee.getDeptID(), employee.getFirstName(), employee.getLastName(),
		employee.getBorn());
    }

    @Override
    public void secondaryDelete(long empID) {
	secondaryJdbcTemplate.update("DELETE FROM target_employees WHERE empID= ?", empID);
    }

    @Override
    public List<Employee2> secondaryQueryAll() {
	return secondaryJdbcTemplate.query("SELECT * FROM target_employees", secondaryRowMapper);
    }

    @Override
    public Employee2 secondaryQueryByNo(long empID) {
	return secondaryJdbcTemplate.queryForObject("SELECT * FROM target_employees WHERE empID = ?",
		new Object[] { empID }, secondaryRowMapper);
    }
}
