package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.hibernate.SessionManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class AppUserOperationsService {

    private final AppUserRepository appUserRepository;
    private final SessionManagerService session;
    private final AppUserValidateToolsService appUserValidateToolsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(requestDTO.getOldUsername());
        if (!appUserValidateToolsService.checkIfUserExists(requestDTO.getNewUsername())) {

            appUserEntity.setUsername(requestDTO.getNewUsername());
            session.getSession().update(appUserEntity);
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {

            throw new IllegalArgumentException("User with given username already exists");

        }
    }

    @Transactional
    public boolean updatePassword(UpdatePasswordRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(requestDTO.getUsername());

        if (bCryptPasswordEncoder.matches(requestDTO.getOldPassword(), appUserEntity.getPassword())) {

            appUserEntity.setPassword(bCryptPasswordEncoder.encode(requestDTO.getNewPassword()));
            session.getSession().update(appUserEntity);
            return true;
        } else {

            return false;

        }

    }

    @Transactional
    public boolean deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

        if (requestDTO.getPassword().equals(requestDTO.getPasswordConfirmation())) {

            session.getSession().delete(appUserRepository.findAppUserEntitiesByUsername(requestDTO.getUsername()));
            return true;

        } else {

            return false;

        }

    }

    @Transactional
    public UserResponseDTO updateDescription(UpdateDescriptionRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(requestDTO.getUsername());
            appUserEntity.setDescription(requestDTO.getDescription());
            session.getSession().update(appUserEntity);
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {


            throw new IllegalArgumentException("something went wrong while u've been trying to set description");

        }

    }

    @Transactional
    public UserResponseDTO updateImage(UpdateImageRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(requestDTO.getUsername());
            appUserEntity.setImage(requestDTO.getImageURL());
            session.getSession().update(appUserEntity);
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {

            throw new IllegalArgumentException("something went wrong while u've been trying to set image");

        }

    }

}
