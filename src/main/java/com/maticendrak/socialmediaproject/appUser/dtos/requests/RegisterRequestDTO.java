package com.maticendrak.socialmediaproject.appUser.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
@Immutable
public class RegisterRequestDTO {

    private String username;
    private String password;

    @Nullable
    private String email;

}
