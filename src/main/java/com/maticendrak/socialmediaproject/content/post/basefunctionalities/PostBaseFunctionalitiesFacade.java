package com.maticendrak.socialmediaproject.content.post.basefunctionalities;

import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.UpdatePostContentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostBaseFunctionalitiesFacade {

    private final PostCreatingService postCreatingService;
    private final PostOperationsService postOperationsService;

    public void addNewPost(AddPostRequestDTO requestDTO) {

        postCreatingService.saveNewPostToDatabaseAndDTO(requestDTO);

    }

    public void deletePostById(Long postId) {

        postOperationsService.deletePostById(postId);

    }

    public ResponseEntity updatePostContent(UpdatePostContentRequestDTO requestDTO) {

        return postOperationsService.updatePostContent(requestDTO);

    }

}
