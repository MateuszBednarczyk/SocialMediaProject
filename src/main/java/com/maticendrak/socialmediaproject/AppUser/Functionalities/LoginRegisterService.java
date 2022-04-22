package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.DTOs.LoginResponseDTO;
import com.maticendrak.socialmediaproject.AppUser.AppUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class LoginRegisterService {
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public LoginResponseDTO login(String username, String password) {

        AppUserEntity foundUser = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(username);

        //if user is not null and password is correct, return user data from db
        if (foundUser != null) {

            if (!bCryptPasswordEncoder.matches(password, foundUser.getPassword())) {

                return null;

            } else {

                return new LoginResponseDTO(foundUser.getUsername(), foundUser.getDescription(), foundUser.getImage(), foundUser.getPosts(), foundUser.getFollowing());

            }

        } else {

            return null;

        }
    }

    @Transactional
    public LoginResponseDTO register(String username, String password) {

        //if user exists return null, else register new user
        if (checkIfUserExists(username)) {

            return null;

        } else {

            AppUserEntity newUser = new AppUserEntity(username, password);
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            appUserRepository.save(newUser);
            return new LoginResponseDTO(newUser.getUsername(), newUser.getDescription(), newUser.getImage(), newUser.getPosts(), newUser.getFollowing());

        }
    }

    public boolean checkIfUserExists(String username) {

        if (appUserRepository.findAppUserEntitiesByUsername(username) != null) {

            return true;

        } else {

            return false;

        }
    }

}
