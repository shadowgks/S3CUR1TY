package com.example.s3cur1ty.dto.res;

import com.example.s3cur1ty.model.entites.PermissionGroup;
import com.example.s3cur1ty.model.entites.Role;
import com.example.s3cur1ty.model.enums.RoleType;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserResDTO(
        String accessToken,
        String fullName,
        String username,
        String email,
        Set<Role> roles,
        Set<PermissionGroup> permissionGroup
) {
}
