package com.example.s3cur1ty.dtos;

import javax.validation.constraints.NotNull;

public record LoginDTO(
        @NotNull(message = "Email must have not be null")
        String email,
        @NotNull(message = "Password must have not be null")
        String password
) {
}
