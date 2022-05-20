package com.maticendrak.socialmediaproject.appuser;

import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.BaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FindUserByUsernameRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class BaseFunctionalitiesController {

    private final BaseFunctionalitiesFacade baseFunctionalitiesFacade;

    @GetMapping("/api/basefunctionalities/finduserbyusername")
    public ResponseEntity<UserResponseDTO> findUserByUsername(@RequestBody FindUserByUsernameRequestDTO requestDTO) {

        return baseFunctionalitiesFacade.findUserByUsername(requestDTO);

    }

}
