package com.example.s3cur1ty.service.impls;

import com.example.s3cur1ty.model.entites.Permission;
import com.example.s3cur1ty.repositorie.PermissionRepository;
import com.example.s3cur1ty.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    @Override
    public List<Permission> findAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }
}
