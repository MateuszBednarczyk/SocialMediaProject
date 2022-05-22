package com.maticendrak.socialmediaproject.appuser.utlis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserUtilsFacade {

    private final ValidateToolsService validateToolsService;

    public boolean checkIfUserExistsByUsername(String username){

        return validateToolsService.checkIfUserExistsByUsername(username);

    }

    public boolean checkIfUserExistsById(Long id){

        return validateToolsService.checkIfUserExistsById(id);

    }

}
