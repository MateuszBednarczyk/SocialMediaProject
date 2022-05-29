package com.maticendrak.socialmediaproject.content.post.basefunctionalities;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.maticendrak.socialmediaproject.content.post.PostRepository;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.UpdatePostContentRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.UpdatePostTitleRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.responses.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class PostOperationsService {

    private final PostRepository postRepository;

    @Transactional
    public void deletePostById(Long postId) {

        PostEntity postEntity = postRepository.findByPostId(postId);
        postRepository.delete(postEntity);

    }

    @Transactional
    public ResponseEntity updatePostContent(UpdatePostContentRequestDTO requestDTO) {

        ResponseEntity response;
        PostEntity postEntity = postRepository.findByPostId(requestDTO.getPostId());

        if (postEntity != null) {

            postEntity.setPostContent(requestDTO.getNewContent());
            PostResponseDTO responseBody = createResponseBody(postEntity);

            response = new ResponseEntity<>(responseBody, HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return response;

    }

    @Transactional
    public ResponseEntity updatePostTitle(UpdatePostTitleRequestDTO requestDTO) {

        ResponseEntity response;
        PostEntity postEntity = postRepository.findByPostId(requestDTO.getPostId());

        if (postEntity != null) {

            postEntity.setPostTitle(requestDTO.getNewTitle());
            PostResponseDTO responseBody = createResponseBody(postEntity);

            response = new ResponseEntity<>(responseBody, HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return response;

    }

    private PostResponseDTO createResponseBody(PostEntity postEntity) {
        return new PostResponseDTO(
                postEntity.getPostId(),
                postEntity.getAuthor().getUsername(),
                postEntity.getPostTitle(),
                postEntity.getPostContent(),
                postEntity.getComments()
        );
    }

}
