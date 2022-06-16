package com.maticendrak.socialmediaproject.content.comment.basefunctionalities;

import com.maticendrak.socialmediaproject.content.comment.dtos.requests.CreateCommentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentBaseFunctionalitiesFacade {

    private final CommentCreatingService commentCreatingService;

    public ResponseEntity createComment(CreateCommentRequestDTO requestDTO) {

        return commentCreatingService.createComment(requestDTO);

    }

}
