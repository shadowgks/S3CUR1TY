package com.example.s3cur1ty.repositorie;

import com.example.s3cur1ty.model.entites.Role;
import com.example.s3cur1ty.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(RoleType name);

}
