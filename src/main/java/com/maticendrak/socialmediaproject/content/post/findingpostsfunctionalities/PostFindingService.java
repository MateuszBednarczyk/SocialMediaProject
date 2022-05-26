package com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.AppUserBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PostFindingService {

    private final PostRepository postRepository;
    private final AppUserBaseFunctionalitiesFacade appUserBaseFunctionalitiesFacade;

    public List<PostEntity> findAllPostsOfRequestedAppUser(String authorUsername) {

        AppUserEntity appUserEntity = appUserBaseFunctionalitiesFacade.getAppUserAsEntity(authorUsername);
        if (appUserEntity != null) {

            return postRepository.findAllByAuthor(appUserEntity);

        } else {

            throw new IllegalArgumentException("something went wrong");

        }

    }

}
