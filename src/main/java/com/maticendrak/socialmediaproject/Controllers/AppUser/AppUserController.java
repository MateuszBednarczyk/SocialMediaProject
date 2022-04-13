package com.maticendrak.socialmediaproject.Controllers.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.RequestsDTO.LoginAndRegisterRequest;
import com.maticendrak.socialmediaproject.Services.AppUser.LoginRegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AppUserController {

    private LoginRegisterService loginRegisterService;

    public AppUserController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    @GetMapping("/login")
    public AppUserEntity login(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        return loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

    }

    @PostMapping("/register")
    public void register(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

    }

}
