package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appUser.verificationtoken.VerificationTokenFacade;
import com.maticendrak.socialmediaproject.mailing.MailFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class AppUserOperationsService {

    private final AppUserRepository appUserRepository;
    private final AppUserValidateToolsService appUserValidateToolsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final VerificationTokenFacade verificationTokenFacade;
    private final MailFacade mailFacade;

    @Transactional
    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getOldUsername());
        if (!appUserValidateToolsService.checkIfUserExists(requestDTO.getNewUsername())) {

            appUserEntity.setUsername(requestDTO.getNewUsername());
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

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
    public UserResponseDTO updateDescription(UpdateDescriptionRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
            appUserEntity.setDescription(requestDTO.getDescription());
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {


            throw new IllegalArgumentException("something went wrong while u've been trying to set description");

        }

    }

    @Transactional
    public UserResponseDTO updateImage(UpdateImageRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
            appUserEntity.setImage(requestDTO.getImageURL());
            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("something went wrong while u've been trying to set image");

        }

    }

    @Transactional
    public UserResponseDTO updateEmail(UpdateEmailRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

            if (requestDTO.getOldEmail().equals(appUserEntity.getEmail())) {

                appUserEntity.setEmail(requestDTO.getNewEmail());

            }

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("something went wrong while u've been trying to set email");

        }

    }

    @Transactional
    public UserResponseDTO updateRole(UpdateRoleRequestDTO requestDTO) {

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
            appUserEntity.setRole(requestDTO.getNewRole());

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("something went wrong while u've been trying to set new role");

        }

    }

    @Transactional
    public boolean deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

        if (requestDTO.getPassword().equals(requestDTO.getPasswordConfirmation())) {

            appUserRepository.deleteAppUserEntityByUsername(requestDTO.getUsername());
            return true;

        } else {

            return false;

        }

    }

}
