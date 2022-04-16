package com.maticendrak.socialmediaproject.ResponsesDTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.List;

@Data
public class LoginResponse {
    @Getter @Setter private String username;
    @Getter @Setter private String description;
    @Getter @Setter private String image;
    @Getter @Setter private List posts;
    @Getter @Setter private List following;

    public LoginResponse(String username, String description, String image, List posts, List following) {
        this.username = username;
        this.description = description;
        this.image = image;
        this.posts = posts;
        this.following = following;
    }
}
