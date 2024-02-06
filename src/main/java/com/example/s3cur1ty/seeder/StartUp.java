package com.example.s3cur1ty.seeder;

import com.example.s3cur1ty.model.entites.AppUser;
import com.example.s3cur1ty.model.entites.Permission;
import com.example.s3cur1ty.model.entites.PermissionGroup;
import com.example.s3cur1ty.model.entites.Role;
import com.example.s3cur1ty.model.enums.ActionType;
import com.example.s3cur1ty.model.enums.RoleType;
import com.example.s3cur1ty.repositorie.PermissionGroupRepository;
import com.example.s3cur1ty.repositorie.RoleRepository;
import com.example.s3cur1ty.service.PermissionService;
import com.example.s3cur1ty.service.RoleService;
import com.example.s3cur1ty.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    private final PermissionService permissionService;
    private final PermissionGroupRepository groupRepository;

    private final Set<String> subjects = Set.of(
            "user",
            "role",
            "task",
            "management"
    );
    private final Set<String> nameGroup = Set.of(
            "stars",
            "simple"
    );

    @Override
    public void run(String... args) throws Exception {

        //insert data roles and permissions
        if(permissionService.findAllPermission().isEmpty() && roleService.findAllRole().isEmpty()){
            for (ActionType action : ActionType.values()) {
                subjects.forEach(
                        subject -> permissionService
                                .createPermission(Permission.builder()
                                .subject(subject.toUpperCase())
                                .action(action)
                                .build())
                );
            }

            for (RoleType role : RoleType.values()){
                roleService.createRole(Role.builder()
                        .name(role)
                        .build());
            }
        }

        //insert data group
        if (groupRepository.findAll().isEmpty()) {
            nameGroup.forEach(name ->
                    groupRepository.save(PermissionGroup.builder()
                            .deadline(LocalDateTime.now().minusDays(6))
                            .name(name.toUpperCase())
                            .permissions(new HashSet<>(permissionService.findAllPermission()))
                            .build())
            );
        }

//        if(userService.findAllUser().isEmpty()){
//            AppUser user1 = AppUser.builder()
//                    .fullName("saad moumou")
//                    .userName("saadmomo")
//                    .email("saad@super_admin.ma")
//                    .password("saad123456789000")
//                    .permissionGroups(Set.of(groupRepository.findPermissionGroupByName("stars").get()))
//                    .build();
//            userService.register(user1);
//        }

    }
}
