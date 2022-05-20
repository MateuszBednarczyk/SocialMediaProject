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

    private final LoginAndRegisterService loginAndRegisterService;
    private final OperationsService operationsService;
    private final VerificationService verificationService;
    private final DataReturnerService dataReturnerService;

    public ResponseEntity<UserResponseDTO> login(LoginRequestDTO requestDTO) {

        return loginAndRegisterService.login(requestDTO);

    }

    public ResponseEntity<UserResponseDTO> register(RegisterRequestDTO requestDTO) {

        return loginAndRegisterService.register(requestDTO);

    }

    public UserResponseDTO updateUsername(UpdateUsernameRequestDTO requestDTO) {

        return operationsService.updateUsername(requestDTO);

    }

    public String updatePassword(UpdatePasswordRequestDTO requestDTO) {

        return operationsService.updatePassword(requestDTO);

    }

    public String deleteAppUser(DeleteAppUserRequestDTO requestDTO) {

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

    public ModelAndView verifyAppUser(VerifyAppUserRequestDTO requestDTO) {

        return verificationService.verifyAppUser(requestDTO);

    }

    public UserResponseDTO findUser(FindUserByUsernameRequestDTO requestDTO) {

        return dataReturnerService.findUser(requestDTO);

    }


}
