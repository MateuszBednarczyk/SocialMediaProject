package com.maticendrak.socialmediaproject.appuser.utlis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserUtilsFacade {

    private final ValidateToolsService validateToolsService;

    public boolean checkIfUserExists(String username){

        return validateToolsService.checkIfUserExists(username);

    }

}
