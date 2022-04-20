package com.maticendrak.socialmediaproject.Controllers.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.RequestsDTOs.LoginAndRegisterRequest;
import com.maticendrak.socialmediaproject.ResponsesDTOs.LoginResponse;
import com.maticendrak.socialmediaproject.Services.AppUser.LoginRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class AppUserController {
    private final LoginRegisterService loginRegisterService;
    private HttpStatus codeToReturn;

    @RequestMapping(value = "/user/login")
    public ResponseEntity login(@RequestBody LoginAndRegisterRequest givenUserCredentials) {

        //goes to login service with given credentials
        AppUserEntity user = loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());
        ResponseEntity<LoginResponse> response;

        //checking if user found correctly
        if (user == null) {

            //if no, pass not found error
            codeToReturn = HttpStatus.NOT_FOUND;
            response = new ResponseEntity<>(codeToReturn);

        } else {

            //if yes, set up user model as a response and then return
            codeToReturn = HttpStatus.OK;
            LoginResponse userEntityToReturn = new LoginResponse(user.getUsername(), user.getDescription(), user.getImage(),
                    user.getPosts(), user.getFollowing());
            response = new ResponseEntity<>(userEntityToReturn, codeToReturn);

        }

        return response;

    }

    @RequestMapping("/user/register")
    public ResponseEntity register(@RequestBody LoginAndRegisterRequest givenUserCredentials) {

        //Check if users exists
        if (loginRegisterService.checkIfUserExists(givenUserCredentials.getUsername())) {

            //if user already exists, api drops conflict (409)
            codeToReturn = HttpStatus.CONFLICT;

        } else {

            //if user doesn't exist it goes to register method
            AppUserEntity newUser = loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

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

}

