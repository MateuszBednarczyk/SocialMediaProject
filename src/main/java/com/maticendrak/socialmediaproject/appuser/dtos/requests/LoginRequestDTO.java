package com.maticendrak.socialmediaproject.appuser.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class LoginRequestDTO {

    private String username;
    private String password;

}
