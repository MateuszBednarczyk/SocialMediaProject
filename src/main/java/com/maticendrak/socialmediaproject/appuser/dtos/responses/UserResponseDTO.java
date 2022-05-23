package com.maticendrak.socialmediaproject.appuser.dtos.responses;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@Immutable
public class UserResponseDTO {

    private String username;
    private String email;
    private String description;
    private String image;

    @Nullable
    private Set<PostEntity> posts;

    @Nullable
    private List<Long> followedUsers;
    private String role;

}
