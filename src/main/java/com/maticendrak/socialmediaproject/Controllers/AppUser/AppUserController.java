package com.maticendrak.socialmediaproject.Controllers.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.RequestsDTO.LoginAndRegisterRequest;
import com.maticendrak.socialmediaproject.Services.AppUser.LoginRegisterService;
import com.sun.jdi.Method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@RestController
public class AppUserController {

    private LoginRegisterService loginRegisterService;

    public AppUserController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    @GetMapping("/user/login")
    public ModelAndView login(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        AppUserEntity object = loginRegisterService.login(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

        ModelAndView correctCredentials = new ModelAndView("redirect:/home", "AppUserEntity", object);
        ModelAndView badCredentials = new ModelAndView("redirect:/user/login");

        if(object == null){

            return badCredentials;

        }else{

            return correctCredentials;

        }
    }

    @Transactional
    @PostMapping("/user/register")
    public void register(@RequestBody LoginAndRegisterRequest givenUserCredentials){

        loginRegisterService.register(givenUserCredentials.getUsername(), givenUserCredentials.getPassword());

    }

    @GetMapping("/home")
    public String test(){

        return "hello";

    }

}
