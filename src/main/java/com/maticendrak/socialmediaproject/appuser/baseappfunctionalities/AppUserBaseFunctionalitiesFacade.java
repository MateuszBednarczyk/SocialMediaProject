package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowAndUnfollowAppUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserBaseFunctionalitiesFacade {

    private final AppUserFindingService appUserFindingService;
    private final AppUserFollowService appUserFollowService;
    private final AppUserDataReturnService appUserDataReturnService;

    public ResponseEntity<UserResponseDTO> findUserByUsername(String username) {

        return appUserFindingService.findUserByUsername(username);

    }

    public ResponseEntity<UserResponseDTO> findUserById(Long id) {

        return appUserFindingService.findUserById(id);

    }

    public ResponseEntity<UserResponseDTO> followUser(FollowAndUnfollowAppUserRequestDTO requestDTO) {

        return appUserFollowService.followUser(requestDTO);

    }

    public ResponseEntity<UserResponseDTO> unfollowUser(FollowAndUnfollowAppUserRequestDTO requestDTO) {

        return appUserFollowService.unfollowUser(requestDTO);

    }

    public ResponseEntity<List<Long>> getFollowedAppUsersPosts(String requestingAppUserUsername) {

        return appUserDataReturnService.getFollowedAppUsersPosts(requestingAppUserUsername);

    }

    public AppUserEntity getAppUserAsEntity(String username) {

        return appUserFindingService.getAppUserAsEntity(username);

    }

}
