package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseFunctionalitiesFacade {

    private final UserFindingService userFindingService;
    private final FollowService followService;

    public ResponseEntity<UserResponseDTO> findUserByUsername(String username) {

        return userFindingService.findUserByUsername(username);

    }

    public ResponseEntity<UserResponseDTO> findUserById(Long id){

        return userFindingService.findUserById(id);

    }

    public ResponseEntity<UserResponseDTO> followUser(FollowUserRequestDTO requestDTO) {

        return followService.followUser(requestDTO);

    }

}
