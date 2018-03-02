package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.domain.Employee;

/**
 * @Transactional 支持事物
 *
 */
@Service
public class EmployeeService implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Employee的对象Mapper
     */
    private static final RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
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

    @Override
    @Transactional
    public void add(Employee employee) {
	jdbcTemplate.update(
		"INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?)",
		employee.getEmpNo(), employee.getBirthDate(), employee.getFirstName(), employee.getLastName(),
		employee.getGender(), employee.getHireDate());
	jdbcTemplate.update("UPDATE employees SET hire_date = ? WHERE emp_no= ?", new Date(System.currentTimeMillis() - 3600000L * 24L),
		employee.getEmpNo());
    }

    @Override
    @Transactional
    public void delete(long empNo) {
	jdbcTemplate.update("DELETE FROM employees WHERE emp_no= ?", empNo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> queryAll() {
	return jdbcTemplate.query("SELECT * FROM employees WHERE gender = 'M' AND first_name LIKE 'K%'", rowMapper);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee queryByNo(long empNo) {
	return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE emp_no = ?", new Object[] { empNo },
		rowMapper);
    }
}
