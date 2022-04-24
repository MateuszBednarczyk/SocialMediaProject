package com.maticendrak.socialmediaproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {


    //from https://stackoverflow.com/a/71818634
    //For an unmatched route, returns react app
    //necessary for react routing
    @RequestMapping(value = { "/", "/{x:^(?!api$).*$}/*/{y:[\\w\\-]+}" })
    public String getIndex(HttpServletRequest request) {
        return "index.html";
    }

}
