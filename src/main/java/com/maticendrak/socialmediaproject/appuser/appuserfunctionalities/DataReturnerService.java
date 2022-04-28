package com.maticendrak.socialmediaproject.appuser.appuserfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FindUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


//Service when methods are returning filtered data
@Service
@RequiredArgsConstructor
class DataReturnerService {
    private final AppUserRepository appUserRepository;
    private final ValidateToolsService validateToolsService;

    @Transactional
    public UserResponseDTO findUser(FindUserRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

        if (validateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("Bad args");

        }

    }
}
