package com.maticendrak.socialmediaproject.appuser.dtos.responses;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.post.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@Immutable
public class UserResponseDTO {

    private String username;
    private String email;
    private String description;
    private String image;
    private PostEntity posts;
    private AppUserEntity appUserEntity;
    private String role;

}
