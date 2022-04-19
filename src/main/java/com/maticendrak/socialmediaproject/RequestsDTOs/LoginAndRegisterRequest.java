package com.maticendrak.socialmediaproject.RequestsDTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginAndRegisterRequest {

    private String username;
    private String password;

}
