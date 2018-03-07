package com.security.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.security.entity.model.SysResource;

public interface SysResourceRepository extends JpaRepository<SysResource,Integer> {

    /**
     *  通过角色名称获取资源列表
     * @param rolename
     * @return
     *
     */
    @Query(value = "SELECT * FROM sys_resource  WHERE id IN ( SELECT resource_id FROM sys_resource_role  WHERE role_id = ( SELECT  id  FROM sys_role  WHERE role_name = ?1))",nativeQuery = true)
    List<SysResource> findByRoleName(String rolename);
}