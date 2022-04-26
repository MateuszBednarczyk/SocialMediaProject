package com.maticendrak.socialmediaproject.appUser.appuserfunctionalities;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AppUserFacade {

    private final LoginAndRegisterService loginAndRegisterService;
    private final OperationsService operationsService;
    private final ValidateToolsService validateToolsService;
    private final VerificationService verificationService;
    private final DataReturnerService dataReturnerService;

    public UserResponseDTO login(LoginRequestDTO requestDTO) {

        return loginAndRegisterService.login(requestDTO);

    }

    public UserResponseDTO register(RegisterRequestDTO requestDTO) {

        return loginAndRegisterService.register(requestDTO);

    }

    public boolean checkIfUserExists(String username) {

        return validateToolsService.checkIfUserExists(username);

    }

    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO requestDTO) {

        return operationsService.updateUsername(requestDTO);

    }

    public boolean updatePassword(UpdatePasswordRequestDTO requestDTO) {

        return operationsService.updatePassword(requestDTO);

    }

    public boolean deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

        return operationsService.deleteAppUser(requestDTO);

    }

    public UserResponseDTO updateDescription(UpdateDescriptionRequestDTO requestDTO) {

        return operationsService.updateDescription(requestDTO);

    }

    public UserResponseDTO updateImage(UpdateImageRequestDTO requestDTO) {

        return operationsService.updateImage(requestDTO);

    }

    public UserResponseDTO updateRole(UpdateRoleRequestDTO requestDTO) {

        return operationsService.updateRole(requestDTO);

    }

    public void sendVerificationMail(SendMailRequestDTO requestDTO, HttpServletRequest httpServletRequest) {

        verificationService.sendVerificationMail(requestDTO, httpServletRequest);

    }

    public UserResponseDTO verifyAppUser(VerifyAppUserRequestDTO requestDTO) {

        return verificationService.verifyAppUser(requestDTO);

    }

    public UserResponseDTO findUser(FindUserRequestDTO requestDTO) {

        return dataReturnerService.findUser(requestDTO);

    }


}
