package com.maticendrak.socialmediaproject.appuser.datamanagementfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppUserDataManagementFacade {

    private final ContentService contentService;

    public Set<PostEntity> getAppUserPosts(String username) {

        return contentService.getAppUserPosts(username);

    }

}
