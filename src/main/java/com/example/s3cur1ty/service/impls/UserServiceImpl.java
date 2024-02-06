package com.example.s3cur1ty.service.impls;

import com.example.s3cur1ty.model.entites.AppUser;
import com.example.s3cur1ty.model.enums.RoleType;
import com.example.s3cur1ty.repositorie.PermissionGroupRepository;
import com.example.s3cur1ty.repositorie.RoleRepository;
import com.example.s3cur1ty.repositorie.UserRepository;
import com.example.s3cur1ty.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final PermissionGroupRepository groupRepository;


    @Override
    public List<AppUser> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public AppUser register(AppUser req) {
        AppUser user = AppUser.builder()
                .userName(req.getUsername())
                .email(req.getEmail())
                .fullName(req.getFullName())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();
        roleRepository.findRoleByName(RoleType.GUEST).ifPresent(role -> user.setRoles(Set.of(role)));
        groupRepository.findPermissionGroupByName("stars").ifPresent(permissionGroup -> user.setPermissionGroups(Set.of(permissionGroup)));
        return userRepository.save(user);
    }

    @Override
    public AppUser authenticate(AppUser req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );
        return userRepository.findAppUserByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Not Found Any User"));
    }
}
