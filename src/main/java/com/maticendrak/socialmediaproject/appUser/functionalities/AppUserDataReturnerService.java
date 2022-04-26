package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.FindUserRequestDTO;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class AppUserDataReturnerService {
    private final AppUserRepository appUserRepository;
    private final AppUserValidateToolsService appUserValidateToolsService;

    @Transactional
    public UserResponseDTO findUser(FindUserRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("Bad args");

        }

    }
}
