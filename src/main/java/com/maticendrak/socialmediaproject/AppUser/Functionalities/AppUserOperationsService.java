package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs.UpdatePasswordRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs.UpdateUsernameRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.Hibernate.SessionManagerService;
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

}
