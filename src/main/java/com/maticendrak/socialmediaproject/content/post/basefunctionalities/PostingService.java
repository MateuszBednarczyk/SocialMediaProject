package com.maticendrak.socialmediaproject.content.post.basefunctionalities;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.AppUserBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.PostRepository;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.responses.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PostingService {

    private final AppUserBaseFunctionalitiesFacade appUserBaseFunctionalitiesFacade;
    private final PostRepository postRepository;

    public ResponseEntity addNewPost(AddPostRequestDTO requestDTO) {

        AppUserEntity appUserEntity = appUserBaseFunctionalitiesFacade.getAppUserAsEntity(requestDTO.getUsername());
        PostEntity postEntity = new PostEntity(appUserEntity, requestDTO.getPostTitle(), requestDTO.getPostContent());

        return new ResponseEntity<>(createNewPostOperations(postEntity, appUserEntity));

    }

    public HttpStatus createNewPostOperations(PostEntity postEntity, AppUserEntity appUserEntity) {

        if (postEntity != null && appUserEntity != null) {

            savePostInDatabase(postEntity);
            addPostEntityToAppUserEntity(postEntity, appUserEntity);

            return HttpStatus.OK;

        } else {

            return HttpStatus.BAD_REQUEST;

        }
    }

    private void savePostInDatabase(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    private void addPostEntityToAppUserEntity(PostEntity postEntity, AppUserEntity appUserEntity) {
        appUserEntity.getPosts().add(postEntity);
    }

}
