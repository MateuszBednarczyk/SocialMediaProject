package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appuser.utlis.AppUserUtilsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class FollowService {

    private final AppUserRepository appUserRepository;
    private final AppUserUtilsFacade appUserUtilsFacade;

    @Transactional
    public ResponseEntity<UserResponseDTO> followUser(FollowUserRequestDTO requestDTO) {
        ResponseEntity<UserResponseDTO> response;

        if (appUserUtilsFacade.checkIfUserExists(requestDTO.getUsernameOfRequestingUser()) && appUserUtilsFacade.checkIfUserExists(requestDTO.getUsernameOfTargetUser())) {

            AppUserEntity requestingAppUser = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsernameOfRequestingUser());
            AppUserEntity targetAppUser = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsernameOfTargetUser());

            requestingAppUser.getFollowing().add(targetAppUser.getId());

            UserResponseDTO responseBody = new UserResponseDTO(requestingAppUser.getUsername(), requestingAppUser.getEmail(),
                    requestingAppUser.getDescription(), requestingAppUser.getImage(), requestingAppUser.getPosts(), requestingAppUser.getFollowing(), requestingAppUser.getRole());

            response = new ResponseEntity<>(responseBody, HttpStatus.CREATED);
            return response;

        } else {

            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return response;

        }
    }
}
