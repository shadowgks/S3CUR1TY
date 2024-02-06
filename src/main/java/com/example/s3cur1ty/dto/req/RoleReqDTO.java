package com.example.s3cur1ty.dto.req;

import javax.validation.constraints.NotNull;

public record RoleReqDTO(
        @NotNull(message = "Name role must not be have null!")
        String name
) {
}
