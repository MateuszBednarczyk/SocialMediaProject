package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.DTOs.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserFacade {

    private final LoginRegisterService loginRegisterService;
    private final AppUserOperationsService appUserOperationsService;
    private final AppUserValidateToolsService appUserValidateToolsService;

    public LoginResponseDTO login(String username, String password) {

        return loginRegisterService.login(username, password);

    }

    public LoginResponseDTO register(String username, String password) {

        return loginRegisterService.register(username, password);

    }

    public boolean checkIfUserExists(String username) {

        return appUserValidateToolsService.checkIfUserExists(username);

    }

    public LoginResponseDTO updateUsername(String oldUsername, String newUsername) {

        return appUserOperationsService.updateUsername(oldUsername, newUsername);

    }

}
