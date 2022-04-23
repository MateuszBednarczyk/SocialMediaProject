package com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class UpdateUsernameRequestDTO {

    String oldUsername;
    String newUsername;

}