package com.maticendrak.socialmediaproject.ResponsesDTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.List;

@Data
public class LoginResponse {
    private String username;
    private String description;
    private String image;
    private List posts;
    private List following;

    public LoginResponse(String username, String description, String image, List posts, List following) {
        this.username = username;
        this.description = description;
        this.image = image;
        this.posts = posts;
        this.following = following;
    }
}
