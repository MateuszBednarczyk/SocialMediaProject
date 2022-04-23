package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs.UpdatePasswordRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.LoginAndRegisterRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Requests.UpdateDTOs.UpdateUsernameRequestDTO;
import com.maticendrak.socialmediaproject.AppUser.DTOs.Responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserFacade {

    private final LoginRegisterService loginRegisterService;
    private final AppUserOperationsService appUserOperationsService;
    private final AppUserValidateToolsService appUserValidateToolsService;

    public UserResponseDTO login(LoginAndRegisterRequestDTO requestDTO) {

        return loginRegisterService.login(requestDTO);

    }

    public UserResponseDTO register(LoginAndRegisterRequestDTO requestDTO) {

        return loginRegisterService.register(requestDTO);

    }

    public boolean checkIfUserExists(String username) {

        return appUserValidateToolsService.checkIfUserExists(username);

    }

    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO requestDTO) {

        return appUserOperationsService.updateUsername(requestDTO);

    }

    public boolean updatePassword(UpdatePasswordRequestDTO requestDTO){

        return appUserOperationsService.updatePassword(requestDTO);

    }

}
