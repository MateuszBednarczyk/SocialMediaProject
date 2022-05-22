package com.maticendrak.socialmediaproject.appuser.utlis;

import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class ValidateToolsService {

    private final AppUserRepository appUserRepository;

    public boolean checkIfUserExistsByUsername(String username) {

        if (appUserRepository.findAppUserEntityByUsername(username) != null) {

            return true;

        } else {

            return false;

        }
    }

    public boolean checkIfUserExistsById(Long id) {

        if (appUserRepository.findAppUserEntityById(id) != null) {

            return true;

        } else {

            return false;

        }
    }

}
