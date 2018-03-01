package com.xml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xml.domain.Employ;

/**
 * XML配置Mapper,包与接口名称  与xml的namespace一致
 */
@Mapper
public interface EmployMapper {
	List<Employ> getAll(@Param("gender") String gender, @Param("firstName") String firstName);

	Employ getOne(@Param("empNo")Long empNo);

	void insert(Employ employee);

	void update(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("empNo") Long empNo);

	void delete(@Param("empNo")Long empNo);
}
