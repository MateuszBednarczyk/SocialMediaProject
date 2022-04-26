package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.LoginRequestDTO;
import com.maticendrak.socialmediaproject.appUser.dtos.requests.RegisterRequestDTO;
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
    public UserResponseDTO login(LoginRequestDTO requestDTO) {

        //if user is not null and password is correct, return user data from db
        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            AppUserEntity foundUser = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

            if (!bCryptPasswordEncoder.matches(requestDTO.getPassword(), foundUser.getPassword())) {

                return null;

            } else {

                return new UserResponseDTO(foundUser.getUsername(), foundUser.getEmail(), foundUser.getDescription(), foundUser.getImage(), foundUser.getPosts(), foundUser.getFollowing(), foundUser.getRole());

            }

        } else {

            return null;

        }
    }

    @Transactional
    public UserResponseDTO register(RegisterRequestDTO requestDTO) {

        //if user exists return null, else register new user
        if (appUserValidateToolsService.checkIfUserExists(requestDTO.getUsername())) {

            return null;

        } else {

            AppUserEntity newUser = new AppUserEntity(requestDTO.getUsername(), requestDTO.getPassword(), requestDTO.getEmail(), "ROLE_NOTVERIFICATED");
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            appUserRepository.save(newUser);
            
            return new UserResponseDTO(newUser.getUsername(), newUser.getEmail(), newUser.getDescription(), newUser.getImage(), newUser.getPosts(), newUser.getFollowing(), newUser.getRole());

        }
    }
}
