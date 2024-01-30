package com.example.s3cur1ty.services;

import com.example.s3cur1ty.models.entites.AppUser;

public interface UserService {
    AppUser register(AppUser user);
    AppUser authenticate(AppUser user);
}
