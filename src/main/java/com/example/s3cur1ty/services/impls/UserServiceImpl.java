package com.example.s3cur1ty.services.impls;

import com.example.s3cur1ty.models.entites.AppUser;
import com.example.s3cur1ty.repositories.UserRepository;
import com.example.s3cur1ty.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository appUserRepository;
    private final AuthenticationManager authenticationManager;


    @Override
    public AppUser register(AppUser req) {
        AppUser user = AppUser.builder()
                .userName(req.getUsername())
                .email(req.getEmail())
                .fullName(req.getFullName())
                .roles(req.getRoles())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();
        return appUserRepository.save(user);
    }

    @Override
    public AppUser authenticate(AppUser req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );
        return appUserRepository.findAppUserByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Not Found Any User"));
    }
}
