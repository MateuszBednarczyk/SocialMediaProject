package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.LoginAndRegisterRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateUsernameRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserFacade {

    private final LoginRegisterService loginRegisterService;
    private final AppUserOperationsService appUserOperationsService;
    private final AppUserValidateToolsService appUserValidateToolsService;

    public UserResponseDTO login(LoginAndRegisterRequestDTO givenUserCredentials) {

        return loginRegisterService.login(givenUserCredentials);

    }

    public UserResponseDTO register(LoginAndRegisterRequestDTO newUserDTO) {

        return loginRegisterService.register(newUserDTO);

    }

    public boolean checkIfUserExists(String username) {

        return appUserValidateToolsService.checkIfUserExists(username);

    }

    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO updateUsernameRequestDTO) {

        return appUserOperationsService.updateUsername(updateUsernameRequestDTO);

    }

}
