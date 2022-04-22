package com.maticendrak.socialmediaproject.AppUser.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class LoginAndRegisterRequestDTO {

    private String username;
    private String password;

}
