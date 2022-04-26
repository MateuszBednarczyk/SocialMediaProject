package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AppUserFacade {

    private final LoginRegisterService loginRegisterService;
    private final AppUserOperationsService appUserOperationsService;
    private final AppUserValidateToolsService appUserValidateToolsService;

    public UserResponseDTO login(LoginRequestDTO requestDTO) {

        return loginRegisterService.login(requestDTO);

    }

    public UserResponseDTO register(RegisterRequestDTO requestDTO) {

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

    public UserResponseDTO findUser(FindUserRequestDTO requestDTO) {

        return appUserOperationsService.findUser(requestDTO);

    }

    public UserResponseDTO updateRole(UpdateRoleRequestDTO requestDTO) {

        return appUserOperationsService.updateRole(requestDTO);

    }

    public void sendVerificationMail(SendMailRequestDTO requestDTO, HttpServletRequest httpServletRequest) {

        appUserOperationsService.sendVerificationMail(requestDTO, httpServletRequest);

    }

    public UserResponseDTO verifyAppUser(VerifyAppUserRequestDTO requestDTO) {

        return appUserOperationsService.verifyAppUser(requestDTO);

    }

}
