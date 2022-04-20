package com.maticendrak.socialmediaproject.Controllers.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.RequestsDTOs.LoginAndRegisterRequest;
import com.maticendrak.socialmediaproject.ResponsesDTOs.LoginResponse;
import com.maticendrak.socialmediaproject.Services.AppUser.LoginRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@CrossOrigin
@Controller
public class AppUserController {

    private final LoginRegisterService loginRegisterService;
    private HttpStatus codeToReturn;

    public AppUserController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    @Transactional
    @RequestMapping(value = "/user/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        AppUserEntity user = loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());
        LoginResponse userEntityToReturn = new LoginResponse(user.getUsername(), user.getDescription(), user.getImage(),
        user.getPosts(), user.getFollowing());

        if(user == null){

            codeToReturn = HttpStatus.NOT_FOUND;

        }else{

            codeToReturn = HttpStatus.OK;

        }

        ResponseEntity<LoginResponse> response = new ResponseEntity<>(userEntityToReturn, codeToReturn);

        return response;

    }

    @Transactional
    @RequestMapping("/user/register")
    public ResponseEntity register(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        if(loginRegisterService.checkIfUserExists(givenUserCredentials.getUsername())){

            codeToReturn = HttpStatus.BAD_REQUEST;

        }else{

            AppUserEntity newUser = loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

            if(newUser == null){

                codeToReturn = HttpStatus.NOT_FOUND;

            }else{

                codeToReturn = HttpStatus.OK;

            }
        }

        ResponseEntity response = new ResponseEntity<>(codeToReturn);

        return response;

    }

}

