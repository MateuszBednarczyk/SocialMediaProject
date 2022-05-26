package com.maticendrak.socialmediaproject.appuser.datamanagementfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.AppUserBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
class ContentService {

    private final AppUserRepository appUserRepository;
    private final AppUserBaseFunctionalitiesFacade appUserBaseFunctionalitiesFacade;

    public Set<PostEntity> getAppUserPosts(String username) {

        return appUserBaseFunctionalitiesFacade.getAppUserAsEntity(username).getPosts();

    }

}
