package com.maticendrak.socialmediaproject.ResponsesDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.mapping.List;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String username;
    private String description;
    private String image;
    private List posts;
    private List following;

}
