package com.maticendrak.socialmediaproject.RequestsDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class LoginAndRegisterRequest {

    private String username;
    private String password;

}
