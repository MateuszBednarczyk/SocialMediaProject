package com.maticendrak.socialmediaproject.appUser.verificationtoken;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    public String generateAndSaveVerificationToken(AppUserEntity appUserEntity) {

        String token = UUID.randomUUID().toString();
        VerificationTokenEntity verificationTokenEntity = new VerificationTokenEntity(token, appUserEntity);
        verificationTokenRepository.save(verificationTokenEntity);

        return verificationTokenEntity.getTokenValue();

    }

    public boolean checkIfTokenIsValid(String token, Long id) {

        if (verificationTokenRepository.findVerificationTokenEntityByUserId(id).getTokenValue().equals(token)) {

            return true;

        } else {

            return false;

        }

    }

}
