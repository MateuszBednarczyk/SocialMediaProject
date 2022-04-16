package com.maticendrak.socialmediaproject.RequestsDTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginAndRegisterRequest {

    @Getter @Setter private String username;
    @Getter @Setter private String password;


}
