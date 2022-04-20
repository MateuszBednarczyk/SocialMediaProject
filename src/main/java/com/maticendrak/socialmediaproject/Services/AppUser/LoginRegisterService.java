package com.maticendrak.socialmediaproject.Services.AppUser;

import com.maticendrak.socialmediaproject.Configurations.SufixConfiguration;
import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.Repositories.AppUser.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterService {
    private AppUserRepository appUserRepository;
    private SufixConfiguration sufixConfiguration;

    public LoginRegisterService(AppUserRepository appUserRepository, SufixConfiguration sufixConfiguration) {
        this.appUserRepository = appUserRepository;
        this.sufixConfiguration = sufixConfiguration;
    }

    public AppUserEntity login(String username, String password){

        AppUserEntity foundUser = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(username);
        if(foundUser != null){

            if(!sufixConfiguration.passwordEncoder().matches(password, foundUser.getPassword())) {

                return null;

            }else{

                return foundUser;

            }

        }else{

            return null;

        }
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

    public boolean checkIfUserExists(String username){

        if(appUserRepository.findAppUserEntitiesByUsername(username) != null){

            return true;

        }else{

            return false;

        }
    }

}
