package com.maticendrak.socialmediaproject.content;

import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import com.maticendrak.socialmediaproject.content.post.basefunctionalities.PostBaseFunctionalitiesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ContentFacade {

    private final PostBaseFunctionalitiesFacade postBaseFunctionalitiesFacade;

    public void addNewPost(AddPostRequestDTO requestDTO) {

        postBaseFunctionalitiesFacade.addNewPost(requestDTO);

    }

}
