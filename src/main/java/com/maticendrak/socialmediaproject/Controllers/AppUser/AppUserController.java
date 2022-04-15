package com.maticendrak.socialmediaproject.Controllers.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.RequestsDTO.LoginAndRegisterRequest;
import com.maticendrak.socialmediaproject.Services.AppUser.LoginRegisterService;
import com.sun.jdi.Method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
public class AppUserController {

    private LoginRegisterService loginRegisterService;

    public AppUserController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    @RequestMapping("/login")
    public String returnLoginView(){

        return "index.html";

    }

    @RequestMapping("/user/login")
    public AppUserEntity login(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        return loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

    }

    @Transactional
    @RequestMapping("/user/register")
    public String register(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());
        return "index.html";

    }



}

