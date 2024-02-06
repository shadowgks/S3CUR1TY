package com.example.s3cur1ty.repositorie;

import com.example.s3cur1ty.model.entites.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
    Optional<PermissionGroup> findPermissionGroupByName(String name);
}
