package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.config.DataSourceEnum;
import com.mybatis.config.DataSourceTypeAnno;
import com.mybatis.domain.TargetEmployee;

/**
 *
 */
public interface TargetEmployeeMapper {
	@DataSourceTypeAnno(DataSourceEnum.secondary)
    @Select("SELECT * FROM target_employees WHERE firstName like #{firstName}")
    @Results({ @Result(property = "empID", column = "empID", javaType = Long.class),
	    @Result(property = "deptID", column = "deptID"), @Result(property = "firstName", column = "firstName"),
	    @Result(property = "lastName", column = "lastName"), @Result(property = "born", column = "born") })
    List<TargetEmployee> getAll(@Param("firstName") String firstName);

	@DataSourceTypeAnno(DataSourceEnum.secondary)
    @Select("SELECT * FROM target_employees WHERE empID = #{empID}")
    @Results({ @Result(property = "empID", column = "empID", javaType = Long.class),
	    @Result(property = "deptID", column = "deptID"), @Result(property = "firstName", column = "firstName"),
	    @Result(property = "lastName", column = "lastName"), @Result(property = "born", column = "born") })
    TargetEmployee getOne(Long empNo);

	@DataSourceTypeAnno(DataSourceEnum.secondary)
    @Insert("INSERT INTO target_employees(empID,deptID,firstName,lastName,born) VALUES(#{empID}, #{deptID}, #{firstName},#{lastName},#{born})")
    void insert(TargetEmployee employee);

	@DataSourceTypeAnno(DataSourceEnum.secondary)
    @Update("UPDATE target_employees SET first_name=#{firstname},last_name=#{lastName} WHERE empID =#{empID}")
    void update(@Param("firstname") String firstname, @Param("lastName") String lastName, @Param("empNo") Long empNo);

	@DataSourceTypeAnno(DataSourceEnum.secondary)
    @Delete("DELETE FROM target_employees WHERE empID =#{empID}")
    void delete(@Param("empID") Long empID);
}
