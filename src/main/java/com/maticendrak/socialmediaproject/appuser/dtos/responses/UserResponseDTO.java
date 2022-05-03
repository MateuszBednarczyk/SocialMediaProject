package com.maticendrak.socialmediaproject.appuser.dtos.responses;

import java.util.List;
import com.maticendrak.socialmediaproject.post.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.util.Set;

@Getter
@AllArgsConstructor
@Immutable
public class UserResponseDTO {

    private String username;
    private String email;
    private String description;
    private String image;
    private Set<PostEntity> posts;
    private List<Long> followedUsers;
    private String role;

}
