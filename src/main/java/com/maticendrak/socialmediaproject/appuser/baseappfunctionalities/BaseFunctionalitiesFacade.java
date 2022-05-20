package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.dtos.requests.FindUserByUsernameRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseFunctionalitiesFacade {

    private final UserFindingService userFindingService;

    public ResponseEntity<UserResponseDTO> findUserByUsername(FindUserByUsernameRequestDTO requestDTO) {

        return userFindingService.findUserByUsername(requestDTO);

    }

}
