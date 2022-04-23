package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.LoginAndRegisterRequestDTO;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class LoginRegisterService {
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserValidateToolsService appUserValidateToolsService;

    @Transactional
    public UserResponseDTO login(LoginAndRegisterRequestDTO givenUserCredentials) {

        AppUserEntity foundUser = (AppUserEntity) appUserRepository.findAppUserEntitiesByUsername(givenUserCredentials.getUsername());

        //if user is not null and password is correct, return user data from db
        if (foundUser != null) {

            if (!bCryptPasswordEncoder.matches(givenUserCredentials.getPassword(), foundUser.getPassword())) {

                return null;

            } else {

                return new UserResponseDTO(foundUser.getUsername(), foundUser.getDescription(), foundUser.getImage(), foundUser.getPosts(), foundUser.getFollowing());

            }

        } else {

            return null;

        }
    }

    @Transactional
    public UserResponseDTO register(LoginAndRegisterRequestDTO newUserDTO) {

        //if user exists return null, else register new user
        if (appUserValidateToolsService.checkIfUserExists(newUserDTO.getUsername())) {

            return null;

        } else {

            AppUserEntity newUser = new AppUserEntity(newUserDTO.getUsername(), newUserDTO.getPassword());
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            appUserRepository.save(newUser);
            return new UserResponseDTO(newUser.getUsername(), newUser.getDescription(), newUser.getImage(), newUser.getPosts(), newUser.getFollowing());

        }
    }
}
