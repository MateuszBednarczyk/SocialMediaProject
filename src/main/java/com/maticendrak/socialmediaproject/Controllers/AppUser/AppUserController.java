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

    private LoginRegisterService loginRegisterService;

    public AppUserController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }


    @Transactional
    @RequestMapping(value = "/user/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        AppUserEntity user = loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());
        LoginResponse loginResponse = new LoginResponse(user.getUsername(), user.getDescription(), user.getImage(),
        user.getPosts(), user.getFollowing());

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);

    }

    @Transactional
    @RequestMapping("/user/register")
    public ResponseEntity register(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

