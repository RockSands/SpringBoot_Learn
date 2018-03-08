package com.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.model.SysRole;

public interface SysRoleRepository extends JpaRepository<SysRole,Integer>{

    @Override
    List<SysRole> findAll();
}
