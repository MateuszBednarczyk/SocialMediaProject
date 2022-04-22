package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.Entities.AppUserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public
class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserEntity foundUser;
        foundUser = (AppUserEntity) Optional.ofNullable(appUserRepository.findAppUserEntitiesByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return foundUser;
    }
}
