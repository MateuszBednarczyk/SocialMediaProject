package com.maticendrak.socialmediaproject.Services.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import com.maticendrak.socialmediaproject.Repositories.AppUser.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserEntity foundUser;
        foundUser = (AppUserEntity)
                Optional.ofNullable(appUserRepository.findAppUserEntitiesByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        if (foundUser == null) {

            throw new UsernameNotFoundException(username);

        }

        return foundUser;
    }
}
