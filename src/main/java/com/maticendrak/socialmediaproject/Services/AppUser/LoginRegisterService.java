package com.maticendrak.socialmediaproject.Services.AppUser;

import com.maticendrak.socialmediaproject.Configurations.SufixConfiguration;
import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.Repositories.AppUser.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterService {

    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;

    public LoginRegisterService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUserEntity login(String username, String password){

        AppUserEntity foundUser = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(username);
        if(!sufixConfiguration.passwordEncoder().matches(foundUser.getPassword(), password)) {

            throw new IllegalArgumentException("Bad credentials");

        }

        return foundUser;

    }

    public AppUserEntity register(String username, String password){

        if(!(appUserRepository.findAppUserEntitiesByUsername(username) == null)){

            throw new IllegalArgumentException("User already exists");

        }
        AppUserEntity newUser = new AppUserEntity(username, password);
        newUser.setPassword(sufixConfiguration.passwordEncoder().encode(newUser.getPassword()));
        appUserRepository.save(newUser);
        return newUser;

    }

}
