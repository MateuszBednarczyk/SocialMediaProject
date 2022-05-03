package com.maticendrak.socialmediaproject.appuser.appuserfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.SendMailRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.VerifyAppUserRequestDTO;
import com.maticendrak.socialmediaproject.appuser.verificationtoken.VerificationTokenFacade;
import com.maticendrak.socialmediaproject.mailing.MailFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView verifyAppUser(VerifyAppUserRequestDTO requestDTO) {

        AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());
        if (verificationTokenFacade.checkIfTokenIsValid(requestDTO.getToken(), appUserEntity.getId())) {

            appUserEntity.setRole("ROLE_VERIFIED");
            return new ModelAndView("redirect:http://localhost:8080");

        } else {

            throw new IllegalArgumentException("Token isn't valid");

        }

    }


}
