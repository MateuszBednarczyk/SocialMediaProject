package com.maticendrak.socialmediaproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "index.html";
    }

    @RequestMapping("/home")
    public String returnLoginView(){

        return "index.html";

    }
}
