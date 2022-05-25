package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.utlis.AppUserUtilsFacade;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
class AppUserDataReturnService {

    private final AppUserUtilsFacade appUserUtilsFacade;
    private final AppUserRepository appUserRepository;

    public ResponseEntity<List<Long>> getFollowedAppUsersPosts(String requestingAppUserUsername) {

        ResponseEntity<List<Long>> response;

        if (appUserUtilsFacade.checkIfUserExistsByUsername(requestingAppUserUsername)) {

            AppUserEntity appUserEntity = (AppUserEntity) appUserRepository.findAppUserEntityByUsername(requestingAppUserUsername);
            List<Set<PostEntity>> responseBody = new ArrayList<>();

            for (Long id : appUserEntity.getFollowing()) {

                responseBody.add(appUserRepository.findAppUserEntityById(id).getPosts());

            }

            response = new ResponseEntity(responseBody, HttpStatus.OK);
            return response;

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return response;

        }
    }
}
