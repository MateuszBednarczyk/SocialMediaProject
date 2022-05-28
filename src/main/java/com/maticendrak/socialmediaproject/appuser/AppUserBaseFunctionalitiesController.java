package com.maticendrak.socialmediaproject.appuser;

import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.AppUserBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.FollowAndUnfollowAppUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AppUserBaseFunctionalitiesController {

    private final AppUserBaseFunctionalitiesFacade appUserBaseFunctionalitiesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/api/basefunctionalities/finduserbyusername/{username}")
    public ResponseEntity<UserResponseDTO> findUserByUsername(@PathVariable String username) {

        return appUserBaseFunctionalitiesFacade.findUserByUsername(username);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/basefunctionalities/finduserbyid/{id}")
    public ResponseEntity<UserResponseDTO> findUserByUsername(@PathVariable Long id) {

        return appUserBaseFunctionalitiesFacade.findUserById(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/basefunctionalities/followuser")
    public ResponseEntity<UserResponseDTO> followUser(@RequestBody FollowAndUnfollowAppUserRequestDTO requestDTO) {

        return appUserBaseFunctionalitiesFacade.followUser(requestDTO);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/basefunctionalities/unfollowuser")
    public ResponseEntity<UserResponseDTO> unfollowUser(@RequestBody FollowAndUnfollowAppUserRequestDTO requestDTO) {

        return appUserBaseFunctionalitiesFacade.unfollowUser(requestDTO);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/basefunctionalities/getfollowedappusersposts")
    public ResponseEntity<List<Long>> getFollowedAppUsersPosts(@RequestParam String requestingAppUserUsername) {

        return appUserBaseFunctionalitiesFacade.getFollowedAppUsersPosts(requestingAppUserUsername);

    }

}
