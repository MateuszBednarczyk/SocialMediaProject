package com.maticendrak.socialmediaproject.appuser;

import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.BaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class BaseFunctionalitiesController {

    private final BaseFunctionalitiesFacade baseFunctionalitiesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/api/basefunctionalities/finduserbyusername/{username}")
    public ResponseEntity<UserResponseDTO> findUserByUsername(@PathVariable String username) {

        return baseFunctionalitiesFacade.findUserByUsername(username);

    }

}
