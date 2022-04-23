package com.maticendrak.socialmediaproject.AppUser;

import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.LoginAndRegisterRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateUsernameRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.Functionalities.AppUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserFacade appUserFacade;
    private HttpStatus codeToReturn;

    @RequestMapping(value = "/user/login")
    public ResponseEntity login(@RequestBody LoginAndRegisterRequestDTO givenUserCredentials) {

        //goes to login service with given credentials
        UserResponseDTO user = appUserFacade.login(givenUserCredentials);
        ResponseEntity<UserResponseDTO> response;

        //checking if user found correctly
        if (user == null) {

            //if no, pass not found error
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            //if yes, set up user model as a response and then return
            response = new ResponseEntity<>(user, HttpStatus.OK);

        }

        return response;

    }

    @RequestMapping(value = "/user/register")
    public ResponseEntity register(@RequestBody LoginAndRegisterRequestDTO givenUserCredentials) {

        //Check if users exists
        if (appUserFacade.checkIfUserExists(givenUserCredentials.getUsername())) {

            //if user already exists, api drops conflict (409)
            codeToReturn = HttpStatus.CONFLICT;

        } else {

            //if user doesn't exist it goes to register method
            UserResponseDTO newUser = appUserFacade.register(givenUserCredentials);

            //checking if register method created user correct
            if (newUser == null) {

                //if no it drops error
                codeToReturn = HttpStatus.NOT_FOUND;

            } else {

                //if yes it just pass ok status to response entity
                codeToReturn = HttpStatus.OK;

            }
        }

        ResponseEntity response = new ResponseEntity<>(codeToReturn);

        return response;

    }

    @RequestMapping(value = "/user/update-username")
    public UserResponseDTO updateUsername(@RequestBody UpdateUsernameRequestDTO updateUsernameRequestDTO) {

        return appUserFacade.updateUsername(updateUsernameRequestDTO);

    }

}

