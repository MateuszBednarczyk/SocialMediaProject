package com.maticendrak.socialmediaproject.appUser.appuserfunctionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.SendMailRequestDTO;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.VerifyAppUserRequestDTO;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appUser.verificationtoken.VerificationTokenFacade;
import com.maticendrak.socialmediaproject.mailing.MailFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
class VerificationService {

    private final AppUserRepository appUserRepository;
    private final VerificationTokenFacade verificationTokenFacade;
    private final MailFacade mailFacade;

    @Transactional
    public void sendVerificationMail(SendMailRequestDTO requestDTO, HttpServletRequest httpServletRequest) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
        requestDTO.setContent("http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath() + "/api/user/verify?token=" + verificationTokenFacade.generateAndSaveVerificationToken(appUserEntity) + "&username=" +
                appUserEntity.getUsername());
        requestDTO.setTitle("Verify your Bit Space Account");
        mailFacade.sendMail(requestDTO);

    }

    @Transactional
    public void verifyAppUser(VerifyAppUserRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
        if (verificationTokenFacade.checkIfTokenIsValid(requestDTO.getToken(), appUserEntity.getId())) {

            appUserEntity.setRole("ROLE_VERIFIED");
            appUserEntity.getAuthorities();
            System.out.println(appUserEntity.getRole());

        } else {

            throw new IllegalArgumentException("Token isn't valid");

        }

    }


}
