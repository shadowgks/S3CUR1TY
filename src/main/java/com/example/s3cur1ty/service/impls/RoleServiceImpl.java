package com.example.s3cur1ty.service.impls;

import com.example.s3cur1ty.model.entites.Role;
import com.example.s3cur1ty.model.enums.RoleType;
import com.example.s3cur1ty.repositorie.RoleRepository;
import com.example.s3cur1ty.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(RoleType name) {
        return roleRepository.findRoleByName(name).orElseThrow();
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
