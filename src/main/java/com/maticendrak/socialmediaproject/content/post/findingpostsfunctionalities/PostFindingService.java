package com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities;

import com.maticendrak.socialmediaproject.appuser.datamanagementfunctionalities.AppUserDataManagementFacade;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.dtos.responses.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class PostFindingService {
    private final AppUserDataManagementFacade appUserDataManagementFacade;

    public ResponseEntity<List<PostResponseDTO>> findAllPostsOfRequestedAppUser(String username) {


        List<PostResponseDTO> responseBody = new ArrayList<>();

        for (PostEntity postEntity : appUserDataManagementFacade.getAppUserPosts(username)) {

            responseBody.add(new PostResponseDTO(
                    postEntity.getAuthor().getUsername(),
                    postEntity.getPostTitle(),
                    postEntity.getPostContent()));

        }

        ResponseEntity<List<PostResponseDTO>> response = new ResponseEntity(responseBody, HttpStatus.OK);

        return response;

    }

}
