package com.example.s3cur1ty.repositorie;

import com.example.s3cur1ty.model.entites.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
