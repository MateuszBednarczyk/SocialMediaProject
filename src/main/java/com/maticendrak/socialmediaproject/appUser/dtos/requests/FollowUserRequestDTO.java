package com.maticendrak.socialmediaproject.appUser.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class FollowUserRequestDTO {

    String usernameOfRequestingUser;
    String usernameOfRequestedUser;

}