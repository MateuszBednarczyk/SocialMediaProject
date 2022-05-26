package com.maticendrak.socialmediaproject.content.contentfinder;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities.PostFindingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ContentFindingFacade {

    private final PostFindingFacade postFindingFacade;

    public List<PostEntity> findAllPostsOfRequestedAppUser(String username) {

        return postFindingFacade.findAllPostsOfRequestedAppUser(username);

    }

}
