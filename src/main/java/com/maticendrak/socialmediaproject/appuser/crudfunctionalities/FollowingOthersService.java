package com.maticendrak.socialmediaproject.appuser.crudfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FollowingOthersService {

    private final AppUserRepository appUserRepository;
//work in progress
//    public UserResponseDTO followOtherUser(FollowUserRequestDTO requestDTO) {
//
//        AppUserEntity requestingUser = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestDTO.getUsernameOfRequestingUser());
//        requestingUser.getFollowing().getCustomSQLInsert("INSERT INTO users ");
//
//    }

}
