package com.security.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    SysUser findByUsername(String username);
}