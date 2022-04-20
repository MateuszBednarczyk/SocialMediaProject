package com.maticendrak.socialmediaproject.API.DTOs.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.mapping.List;

@Data
@AllArgsConstructor
@Immutable
public class LoginResponse {

    private String username;
    private String description;
    private String image;
    private List posts;
    private List following;

}
