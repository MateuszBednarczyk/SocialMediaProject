package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
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

    public boolean updatePassword(UpdatePasswordRequestDTO requestDTO) {

        return appUserOperationsService.updatePassword(requestDTO);

    }

    public boolean deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

        return appUserOperationsService.deleteAppUser(requestDTO);

    }

    public UserResponseDTO updateDescription(UpdateDescriptionRequestDTO requestDTO) {

        return appUserOperationsService.updateDescription(requestDTO);

    }

    public UserResponseDTO updateImage(UpdateImageRequestDTO requestDTO) {

        return appUserOperationsService.updateImage(requestDTO);

    }

}
