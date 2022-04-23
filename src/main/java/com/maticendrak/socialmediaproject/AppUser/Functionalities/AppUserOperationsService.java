package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateUsernameRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.Hibernate.SessionManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class AppUserOperationsService {

    private final AppUserRepository appUserRepository;
    private final SessionManagerService session;
    private final AppUserValidateToolsService appUserValidateToolsService;

    @Transactional
    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO updateUsernameRequestDTO) {

        AppUserEntity existingUser = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(updateUsernameRequestDTO.getOldUsername());
        if (!appUserValidateToolsService.checkIfUserExists(updateUsernameRequestDTO.getNewUsername())) {

            existingUser.setUsername(updateUsernameRequestDTO.getNewUsername());
            session.getSession().update(existingUser);
            return new UserResponseDTO(existingUser.getUsername(), existingUser.getDescription(), existingUser.getImage(), existingUser.getPosts(), existingUser.getFollowing());

        } else {

            throw new IllegalArgumentException("User with given username already exists");

        }
    }

    @Transactional
    public void updatePassword(String oldPassword, String newPassword){



    }

}
