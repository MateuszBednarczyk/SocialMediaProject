package com.maticendrak.socialmediaproject.appuser;

import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.BaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowUserRequestDTO;
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

    @RequestMapping(method = RequestMethod.GET, value = "/api/basefunctionalities/finduserbyid/{id}")
    public ResponseEntity<UserResponseDTO> findUserByUsername(@PathVariable Long id) {

        return baseFunctionalitiesFacade.findUserById(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/basefunctionalities/followuser")
    public ResponseEntity<UserResponseDTO> followUser(@RequestBody FollowUserRequestDTO requestDTO) {

        return baseFunctionalitiesFacade.followUser(requestDTO);

    }

}
