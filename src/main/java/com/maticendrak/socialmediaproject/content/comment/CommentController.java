package com.maticendrak.socialmediaproject.content.comment;

import com.maticendrak.socialmediaproject.content.comment.basefunctionalities.CommentBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.comment.dtos.requests.CreateCommentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentBaseFunctionalitiesFacade commentBaseFunctionalitiesFacade;

    @PostMapping("/api/content/comment/create-comment")
    public ResponseEntity createComment(@RequestBody CreateCommentRequestDTO requestDTO) {

        return commentBaseFunctionalitiesFacade.createComment(requestDTO);

    }

}
