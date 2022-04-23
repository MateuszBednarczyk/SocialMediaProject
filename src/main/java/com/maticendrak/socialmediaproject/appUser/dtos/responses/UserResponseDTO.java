package com.maticendrak.socialmediaproject.appUser.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.mapping.List;

@Getter
@AllArgsConstructor
@Immutable
public class UserResponseDTO {

    private String username;
    private String description;
    private String image;
    private List posts;
    private List following;

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", posts=" + posts +
                ", following=" + following +
                '}';
    }
}
