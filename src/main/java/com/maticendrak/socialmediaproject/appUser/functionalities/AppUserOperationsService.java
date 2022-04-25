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

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getOldUsername());
        if (!appUserValidateToolsService.checkIfUserExists(requestDTO.getNewUsername())) {

            appUserEntity.setUsername(requestDTO.getNewUsername());
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {

            throw new IllegalArgumentException("User with given username already exists");

        }
    }

    @Transactional
    public boolean updatePassword(UpdatePasswordRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

        if (bCryptPasswordEncoder.matches(requestDTO.getOldPassword(), appUserEntity.getPassword())) {

            appUserEntity.setPassword(bCryptPasswordEncoder.encode(requestDTO.getNewPassword()));
            return true;
        } else {

            return false;

        }

    }

    @Transactional
    public boolean deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

        if (requestDTO.getPassword().equals(requestDTO.getPasswordConfirmation())) {

            session.getSession().delete(appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername()));
            return true;

        } else {

            return false;

        }

    }

    @Transactional
    public UserResponseDTO updateDescription(UpdateDescriptionRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
            appUserEntity.setDescription(requestDTO.getDescription());
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {


            throw new IllegalArgumentException("something went wrong while u've been trying to set description");

        }

    }

    @Transactional
    public UserResponseDTO updateImage(UpdateImageRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
            appUserEntity.setImage(requestDTO.getImageURL());
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {

            throw new IllegalArgumentException("something went wrong while u've been trying to set image");

        }

    }

    @Transactional
    public UserResponseDTO findUser(FindUserRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {

            throw new IllegalArgumentException("Bad args");

        }

    }

    @Transactional
    public UserResponseDTO updateEmail(UpdateEmailRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

            if (requestDTO.getOldEmail().equals(appUserEntity.getEmail())) {

                appUserEntity.setEmail(requestDTO.getNewEmail());

            }

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing());

        } else {


            throw new IllegalArgumentException("something went wrong while u've been trying to set email");

        }

    }

}
