package com.example.s3cur1ty.service;

import com.example.s3cur1ty.model.entites.Role;
import com.example.s3cur1ty.model.enums.RoleType;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    Role findRoleByName(RoleType name);
    Role createRole(Role role);
}
