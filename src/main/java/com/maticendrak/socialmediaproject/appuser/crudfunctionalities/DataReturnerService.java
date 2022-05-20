package com.maticendrak.socialmediaproject.appuser.crudfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FindUserByUsernameRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appuser.utlis.AppUserUtilsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


//Service when methods are returning filtered data
@Service
@RequiredArgsConstructor
class DataReturnerService {
    private final AppUserRepository appUserRepository;
    private final AppUserUtilsFacade appUserUtilsFacade;

    @Transactional
    public UserResponseDTO findUser(FindUserByUsernameRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

        if (appUserUtilsFacade.checkIfUserExists(requestDTO.getUsername())) {

            return new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("Bad args");

        }

    }
}
