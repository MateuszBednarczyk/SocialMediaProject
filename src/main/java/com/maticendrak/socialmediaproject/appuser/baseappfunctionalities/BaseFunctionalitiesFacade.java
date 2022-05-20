package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseFunctionalitiesFacade {

    private final UserFindingService userFindingService;

    public ResponseEntity<UserResponseDTO> findUserByUsername(String username) {

        return userFindingService.findUserByUsername(username);

    }

}
