package com.example.s3cur1ty.dtos;


import javax.validation.constraints.NotNull;

public record RegisteredDTO(
        @NotNull(message = "Full Name must have not be null")
        String fullName,
        @NotNull(message = "Username must have not be null")
        String userName,
        @NotNull(message = "Email must have not be null")
        String email,
        @NotNull(message = "Password must have not be null")
        String password
) {
}
