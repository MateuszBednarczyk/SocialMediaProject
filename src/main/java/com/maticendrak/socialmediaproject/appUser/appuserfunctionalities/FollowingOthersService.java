package com.maticendrak.socialmediaproject.appUser.appuserfunctionalities;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.FollowUserRequestDTO;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FollowingOthersService {

    private final AppUserRepository appUserRepository;

//    public UserResponseDTO followOtherUser(FollowUserRequestDTO requestDTO) {
//
//         appUserRepository.findAppUserEntityByUsername(requestDTO.getUsernameOfRequestingUser());
//
//    }

}
