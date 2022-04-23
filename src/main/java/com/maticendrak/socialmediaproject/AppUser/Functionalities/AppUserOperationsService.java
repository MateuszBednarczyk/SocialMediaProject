package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.AppUser.DTOs.LoginResponseDTO;
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
    public LoginResponseDTO updateUsername(String oldUsername, String newUsername) {

        AppUserEntity existingUser = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(oldUsername);
        if(!appUserValidateToolsService.checkIfUserExists(newUsername)){

            existingUser.setUsername(newUsername);
            session.getSession().update(existingUser);
            return new LoginResponseDTO(existingUser.getUsername(), existingUser.getDescription(), existingUser.getImage(), existingUser.getPosts(), existingUser.getFollowing());

        }else{

            throw new IllegalArgumentException("User with given username already exists");

        }
    }

}
