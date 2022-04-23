package com.maticendrak.socialmediaproject.AppUser;

import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.LoginAndRegisterRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs.UpdatePasswordRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs.UpdateUsernameRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.Functionalities.AppUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserFacade appUserFacade;
    private HttpStatus codeToReturn;

    @RequestMapping(value = "/user/login")
    public ResponseEntity login(@RequestBody LoginAndRegisterRequestDTO loginRequestDTO) {

        //goes to login service with given credentials
        UserResponseDTO user = appUserFacade.login(loginRequestDTO);
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
    public ResponseEntity register(@RequestBody LoginAndRegisterRequestDTO registerRequestDTO) {

        //Check if users exists
        if (appUserFacade.checkIfUserExists(registerRequestDTO.getUsername())) {

            //if user already exists, api drops conflict (409)
            codeToReturn = HttpStatus.CONFLICT;

        } else {

            //if user doesn't exist it goes to register method
            UserResponseDTO newUser = appUserFacade.register(registerRequestDTO);

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
    public UserResponseDTO updateUsername(@RequestBody UpdateUsernameRequestDTO requestDTO) {

        return appUserFacade.updateUsername(requestDTO);

    }

    @RequestMapping(value = "/user/update-password")
    public String updatePassword(@RequestBody UpdatePasswordRequestDTO requestDTO) {

        if (appUserFacade.updatePassword(requestDTO)) {

            return "redirect:" + "http://localhost:8080/logout";

        } else {

            throw new IllegalStateException("Passwords aren't same, or password isn't correct");
        }

    }

}

