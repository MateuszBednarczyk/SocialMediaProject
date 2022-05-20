package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FollowService {

    private final AppUserRepository appUserRepository;

    public ResponseEntity<UserResponseDTO> followUser() {
        ResponseEntity<UserResponseDTO> respone;

        respone = new ResponseEntity<>(HttpStatus.CONTINUE);

        return respone;

    }

}
