package com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.FindPostByIdRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.responses.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFindingFacade {

    private final PostFindingService postFindingService;

    public ResponseEntity<List<PostResponseDTO>> findAllPostsOfRequestedAppUser(String username) {

        return postFindingService.findAllPostsOfRequestedAppUser(username);

    }

    public ResponseEntity<PostEntity> findPostById(FindPostByIdRequestDTO requestDTO) {

        return postFindingService.findPostById(requestDTO);

    }

}
