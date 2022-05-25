package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowAndUnfollowAppUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppUserBaseFunctionalitiesFacade {

    private final AppUserFindingService appUserFindingService;
    private final FollowService followService;
    private final AppUserDataReturnService appUserDataReturnService;
    private final ContentService contentService;

    public ResponseEntity<UserResponseDTO> findUserByUsername(String username) {

        return appUserFindingService.findUserByUsername(username);

    }

    public ResponseEntity<UserResponseDTO> findUserById(Long id) {

        return appUserFindingService.findUserById(id);

    }

    public ResponseEntity<UserResponseDTO> followUser(FollowAndUnfollowAppUserRequestDTO requestDTO) {

        return followService.followUser(requestDTO);

    }

    public ResponseEntity<UserResponseDTO> unfollowUser(FollowAndUnfollowAppUserRequestDTO requestDTO) {

        return followService.unfollowUser(requestDTO);

    }

    public ResponseEntity<List<Long>> getFollowedAppUsersPosts(String requestingAppUserUsername) {

        return appUserDataReturnService.getFollowedAppUsersPosts(requestingAppUserUsername);

    }

    public Set<PostEntity> getAppUserPosts(String username) {

        return contentService.getAppUserPosts(username);

    }

    public AppUserEntity getAppUserAsEntity(String username) {

        return appUserFindingService.getAppUserAsEntity(username);

    }

}
