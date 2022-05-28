package com.maticendrak.socialmediaproject.appuser.crudfunctionalities;

import com.maticendrak.socialmediaproject.appuser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserCrudFunctionalitiesFacade {

    private final AppUserLoginAndRegisterService appUserLoginAndRegisterService;
    private final AppUserOperationsService appUserOperationsService;
    private final AppUserVerificationService appUserVerificationService;

    public ResponseEntity<UserResponseDTO> login(LoginRequestDTO requestDTO) {

        return appUserLoginAndRegisterService.login(requestDTO);

    }

    public ResponseEntity<UserResponseDTO> register(RegisterRequestDTO requestDTO) {

        return appUserLoginAndRegisterService.register(requestDTO);

    }

    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO requestDTO) {

        return appUserOperationsService.updateUsername(requestDTO);

    }

    public String updatePassword(UpdatePasswordRequestDTO requestDTO) {

        return appUserOperationsService.updatePassword(requestDTO);

    }

    public String deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

        return appUserOperationsService.deleteAppUser(requestDTO);

    }

    public UserResponseDTO updateDescription(UpdateDescriptionRequestDTO requestDTO) {

        return appUserOperationsService.updateDescription(requestDTO);

    }

    public UserResponseDTO updateImage(UpdateImageRequestDTO requestDTO) {

        return appUserOperationsService.updateImage(requestDTO);

    }

    public UserResponseDTO updateRole(UpdateRoleRequestDTO requestDTO) {

        return appUserOperationsService.updateRole(requestDTO);

    }

    public void sendVerificationMail(SendMailRequestDTO requestDTO, HttpServletRequest httpServletRequest) {

        appUserVerificationService.sendVerificationMail(requestDTO, httpServletRequest);

    }

    public ModelAndView verifyAppUser(VerifyAppUserRequestDTO requestDTO) {

        return appUserVerificationService.verifyAppUser(requestDTO);

    }

}
