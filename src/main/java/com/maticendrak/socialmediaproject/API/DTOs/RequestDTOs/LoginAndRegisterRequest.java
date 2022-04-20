package com.maticendrak.socialmediaproject.API.DTOs.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@AllArgsConstructor
@Immutable
public class LoginAndRegisterRequest {

    private String username;
    private String password;

}
