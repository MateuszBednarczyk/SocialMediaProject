package com.maticendrak.socialmediaproject.content.post;

import com.maticendrak.socialmediaproject.appuser.baseappfunctionalities.BaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.dtos.requests.AddPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class PostingService {

    private final BaseFunctionalitiesFacade baseFunctionalitiesFacade;
    private final PostRepository postRepository;

    public PostEntity createPostEntity(AddPostRequestDTO requestDTO) {

        return new PostEntity(baseFunctionalitiesFacade.getAppUserAsEntity(requestDTO.getUsername()),
                requestDTO.getPostTitle(),
                requestDTO.getPostContent());

    }

    @Transactional
    public void savePostInDatabase(PostEntity createdPost) {

        postRepository.save(createdPost);

    }

    @Transactional
    public void addPostToAppUser(AddPostRequestDTO requestDTO) {

        PostEntity createdPost = createPostEntity(requestDTO);
        if (createdPost != null) {

            baseFunctionalitiesFacade.getAppUserPosts(requestDTO.getUsername())
                    .add(createdPost);
            savePostInDatabase(createdPost);

        }
    }
}
