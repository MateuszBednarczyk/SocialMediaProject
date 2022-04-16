package com.maticendrak.socialmediaproject.Controllers.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.RequestsDTO.LoginAndRegisterRequest;
import com.maticendrak.socialmediaproject.Services.AppUser.LoginRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import static org.springframework.http.MediaType.*;

@CrossOrigin
@Controller
public class AppUserController {

    private LoginRegisterService loginRegisterService;

    public AppUserController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    @RequestMapping("/home")
    public String returnLoginView(){

        return "index.html";

    }

    @Transactional
    @RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = ALL_VALUE)
    public ResponseEntity<AppUserEntity> login(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        AppUserEntity user = loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @Transactional
    @RequestMapping("/user/register")
    public ResponseEntity register(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

