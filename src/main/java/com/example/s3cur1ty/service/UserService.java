package com.example.s3cur1ty.service;

import com.example.s3cur1ty.model.entites.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> findAllUser();
    AppUser register(AppUser user);
    AppUser authenticate(AppUser user);
}
