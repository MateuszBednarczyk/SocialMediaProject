package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowAppUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.GetFollowedAppUsersPostsDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BaseFunctionalitiesFacade {

    private final AppUserFindingService appUserFindingService;
    private final FollowService followService;
    private final AppUserDataReturnService appUserDataReturnService;

    public ResponseEntity<UserResponseDTO> findUserByUsername(String username) {

        return appUserFindingService.findUserByUsername(username);

    }

    public ResponseEntity<UserResponseDTO> findUserById(Long id){

        return appUserFindingService.findUserById(id);

    }

    public ResponseEntity<UserResponseDTO> followUser(FollowAppUserRequestDTO requestDTO) {

        return followService.followUser(requestDTO);

    }

    public ResponseEntity<ArrayList<Set<PostEntity>>> getFollowedAppUsersPosts(GetFollowedAppUsersPostsDTO requestDTO){

        return appUserDataReturnService.getFollowedAppUsersPosts(requestDTO);

    }

}
