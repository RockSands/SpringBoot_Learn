package com.annotation.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.annotation.domain.EmployeeGanderEnum;

/**
 * 该方式适合XML配置
 */
public class EmployeeGanderEnumHandler extends BaseTypeHandler<EmployeeGanderEnum> {

	/* 
	 * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, EmployeeGanderEnum parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getDesc());
	}

	/* 
	 * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
	 */
	@Override
	public EmployeeGanderEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String key = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的key值，定位SexEnum子类
            return EmployeeGanderEnum.valueOf(key);
        }
	}

	/* 
	 * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
	 */
	@Override
	public EmployeeGanderEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String key = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的key值，定位SexEnum子类
            return EmployeeGanderEnum.valueOf(key);
        }
	}

	@Override
	public EmployeeGanderEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String key = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的key值，定位SexEnum子类
            return EmployeeGanderEnum.valueOf(key);
        }
	}

}
