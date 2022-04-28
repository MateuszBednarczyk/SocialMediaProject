package com.maticendrak.socialmediaproject.appuser.verificationtoken;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationTokenFacade {

    private final VerificationTokenService verificationTokenService;

    public String generateAndSaveVerificationToken(AppUserEntity appUserEntity) {

        return verificationTokenService.generateAndSaveVerificationToken(appUserEntity);

    }

    public boolean checkIfTokenIsValid(String token, Long id) {

        return verificationTokenService.checkIfTokenIsValid(token, id);

    }

}
