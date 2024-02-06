package com.example.s3cur1ty.model.entites;

import com.example.s3cur1ty.model.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"userName", "email"})
})
public class AppUser implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users-roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users-groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<PermissionGroup> permissionGroups;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> grantedAuthorityList = new HashSet<>();
//        roles.forEach(role -> grantedAuthorityList
//                .add(new SimpleGrantedAuthority("ROLE_" + role.getName().name())));
        roles.forEach(role -> role.getPermissions()
                .forEach(permission -> grantedAuthorityList.add(new SimpleGrantedAuthority("PERMISSION_"+ permission.getSubject() + ":" +permission.getAction())))
        );
        permissionGroups.forEach(group -> group.getPermissions()
                .forEach(permission -> grantedAuthorityList.add(new SimpleGrantedAuthority("PERMISSION_"+ permission.getSubject() + ":" +permission.getAction())))
        );
        System.out.println(grantedAuthorityList);
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
