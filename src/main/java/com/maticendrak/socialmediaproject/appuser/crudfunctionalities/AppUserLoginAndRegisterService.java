package com.maticendrak.socialmediaproject.appuser.crudfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.LoginRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.RegisterRequestDTO;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appuser.utlis.AppUserUtilsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class AppUserLoginAndRegisterService {
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserUtilsFacade appUserUtilsFacade;

    @Transactional
    public ResponseEntity<UserResponseDTO> login(LoginRequestDTO requestDTO) {

        ResponseEntity<UserResponseDTO> response;

        //if user is not null and password is correct, return user data from db
        if (appUserUtilsFacade.checkIfUserExistsByUsername(requestDTO.getUsername())) {

            AppUserEntity foundUser = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsername());

            if (!bCryptPasswordEncoder.matches(requestDTO.getPassword(), foundUser.getPassword())) {

                response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                return response;

            } else {

                UserResponseDTO responseBody = new UserResponseDTO(foundUser.getUsername(), foundUser.getEmail(), foundUser.getDescription(), foundUser.getImage(), foundUser.getFollowing(), foundUser.getRole());
                response = new ResponseEntity<>(responseBody, HttpStatus.OK);
                return response;

            }

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return response;

        }
    }

    @Transactional
    public ResponseEntity<UserResponseDTO> register(RegisterRequestDTO requestDTO) {

        ResponseEntity<UserResponseDTO> response;

        //if user exists return null, else register new user
        if (appUserUtilsFacade.checkIfUserExistsByUsername(requestDTO.getUsername())) {

            response = new ResponseEntity<>(HttpStatus.CONFLICT);
            return response;

        } else {

            AppUserEntity newUser = new AppUserEntity(requestDTO.getUsername(), requestDTO.getPassword(), requestDTO.getEmail(), "ROLE_UNVERIFIED");
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            appUserRepository.save(newUser);

            UserResponseDTO responseBody = new UserResponseDTO(newUser.getUsername(), newUser.getEmail(), newUser.getDescription(), newUser.getImage(), newUser.getFollowing(), newUser.getRole());
            response = new ResponseEntity<>(responseBody, HttpStatus.OK);

            return response;

        }
    }
}
