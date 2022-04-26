package com.maticendrak.socialmediaproject.appUser.appuserfunctionalities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class ValidateToolsService {

    private final AppUserRepository appUserRepository;

    public boolean checkIfUserExists(String username) {

        if (appUserRepository.findAppUserEntityByUsername(username) != null) {

            return true;

        } else {

            return false;

        }
    }
}
