package com.example.s3cur1ty.repositories;

import com.example.s3cur1ty.models.entites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByUserName(String username);
}
