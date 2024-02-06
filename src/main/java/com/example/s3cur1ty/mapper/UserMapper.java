package com.example.s3cur1ty.mapper;

import com.example.s3cur1ty.dto.req.LoginDTO;
import com.example.s3cur1ty.dto.req.RegisterReqDTO;
import com.example.s3cur1ty.dto.res.UserResDTO;
import com.example.s3cur1ty.model.entites.AppUser;

public class UserMapper {
    public static AppUser toEntity(RegisterReqDTO registerReqDto){
        return AppUser.builder()
                .email(registerReqDto.email())
                .password(registerReqDto.password())
                .userName(registerReqDto.userName())
                .fullName(registerReqDto.fullName())
                .build();
    }

    public static AppUser toEntity(LoginDTO loginDTO){
        return AppUser.builder()
                .email(loginDTO.email())
                .password(loginDTO.password())
                .build();
    }

    public static UserResDTO toDto(AppUser user, String token){
        return UserResDTO.builder()
                .accessToken(token)
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles())
                .permissionGroup(user.getPermissionGroups())
                .build();
    };


}
