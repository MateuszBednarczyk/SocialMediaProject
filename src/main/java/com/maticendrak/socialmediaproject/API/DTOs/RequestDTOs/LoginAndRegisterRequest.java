package com.maticendrak.socialmediaproject.API.DTOs.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginAndRegisterRequest {

    private String username;
    private String password;

}
