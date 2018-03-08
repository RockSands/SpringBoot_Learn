package com.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    SysUser findByUsername(String username);
}
