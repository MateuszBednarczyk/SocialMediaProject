package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class AppUserValidateToolsService {

    private final AppUserRepository appUserRepository;

    public boolean checkIfUserExists(String username) {

        if (appUserRepository.findAppUserEntitiesByUsername(username) != null) {

            return true;

        } else {

            return false;

        }
    }
}