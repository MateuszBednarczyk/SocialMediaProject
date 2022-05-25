package com.maticendrak.socialmediaproject.content.post.basefunctionalities;

import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostBaseFunctionalitiesFacade {

    private final PostingService postingService;

    public void addNewPost(AddPostRequestDTO requestDTO) {

        postingService.addNewPost(requestDTO);

    }

}
