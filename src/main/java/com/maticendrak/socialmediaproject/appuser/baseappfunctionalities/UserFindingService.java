package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appuser.utlis.AppUserUtilsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserFindingService {

    private final AppUserRepository appUserRepository;
    private final AppUserUtilsFacade appUserUtilsFacade;

    public ResponseEntity<UserResponseDTO> findUserByUsername(String username) {

        ResponseEntity<UserResponseDTO> response;

        if (appUserUtilsFacade.checkIfUserExists(username)) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(username);
            UserResponseDTO responseBody = new UserResponseDTO(appUserEntity.getUsername(), appUserEntity.getEmail(), appUserEntity.getDescription(), appUserEntity.getImage(), appUserEntity.getPosts(), appUserEntity.getFollowing(), appUserEntity.getRole());
            response = new ResponseEntity<>(responseBody, HttpStatus.OK);
            return response;

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return response;

        }
    }
}
