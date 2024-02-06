package com.example.s3cur1ty.service;

import com.example.s3cur1ty.model.entites.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAllPermission();
    Permission createPermission(Permission permission);
}
