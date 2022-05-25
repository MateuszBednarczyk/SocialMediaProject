package com.maticendrak.socialmediaproject.appuser.baseappfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserRepository;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
class ContentService {

    private final AppUserRepository appUserRepository;
    private final AppUserFindingService appUserFindingService;

    public Set<PostEntity> getAppUserPosts(String username) {

        return appUserFindingService.getAppUserAsEntity(username).getPosts();

    }

}
