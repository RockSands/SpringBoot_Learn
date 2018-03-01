package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.config.DataSourceEnum;
import com.mybatis.config.DataSourceTypeAnno;
import com.mybatis.domain.TargetEmployee;
import com.mybatis.mapper.TargetEmployeeMapper;

/**
 *
 */
@Service
public class TargetEmplyeeService {
    @Autowired
    private TargetEmployeeMapper targetEmployeeMapper;

    @DataSourceTypeAnno(DataSourceEnum.secondary)
    public List<TargetEmployee> getAll(String firstName) {
	return targetEmployeeMapper.getAll(firstName);
    }

    @DataSourceTypeAnno(DataSourceEnum.secondary)
    public TargetEmployee getOne(Long empNo) {
	return targetEmployeeMapper.getOne(empNo);
    }

    @DataSourceTypeAnno(DataSourceEnum.secondary)
    public void insert(TargetEmployee employee) {
	targetEmployeeMapper.insert(employee);
    }

    @DataSourceTypeAnno(DataSourceEnum.secondary)
    public void update(String firstname, String lastName, Long empNo) {
	targetEmployeeMapper.update(firstname, lastName, empNo);
    }

    @DataSourceTypeAnno(DataSourceEnum.secondary)
    public void delete(Long empID) {
	targetEmployeeMapper.delete(empID);
    }
}
