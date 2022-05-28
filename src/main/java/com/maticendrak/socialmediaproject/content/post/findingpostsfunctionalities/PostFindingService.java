package com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.AppUserBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.PostRepository;
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

    private final PostRepository postRepository;
    private final AppUserBaseFunctionalitiesFacade appUserBaseFunctionalitiesFacade;

    public ResponseEntity<List<PostResponseDTO>> findAllPostsOfRequestedAppUser(String authorUsername) {

        AppUserEntity appUserEntity = appUserBaseFunctionalitiesFacade.getAppUserAsEntity(authorUsername);
        List<PostResponseDTO> responseBody = new ArrayList<>();

        if (appUserEntity != null) {

            createDTO(appUserEntity, responseBody);

            return new ResponseEntity<>(responseBody, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    private void createDTO(AppUserEntity appUserEntity, List<PostResponseDTO> responseBody) {
        for (PostEntity post : postRepository.findAllByAuthor(appUserEntity)) {

            responseBody.add(new PostResponseDTO(
                    post.getPostId(),
                    post.getAuthor().getUsername(),
                    post.getPostTitle(),
                    post.getPostContent(),
                    post.getComments()
            ));

        }
    }

}
