package com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFindingFacade {

    private final PostFindingService postFindingService;

    public List<PostEntity> findAllPostsOfRequestedAppUser(String username) {

        return postFindingService.findAllPostsOfRequestedAppUser(username);

    }

}
