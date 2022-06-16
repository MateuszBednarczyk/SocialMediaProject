package com.maticendrak.socialmediaproject.content.comment.basefunctionalities;

import com.maticendrak.socialmediaproject.content.comment.CommentEntity;
import com.maticendrak.socialmediaproject.content.comment.CommentRepository;
import com.maticendrak.socialmediaproject.content.comment.dtos.requests.CreateCommentRequestDTO;
import com.maticendrak.socialmediaproject.content.comment.dtos.responses.CommentResponseDTO;
import com.maticendrak.socialmediaproject.content.post.basefunctionalities.PostBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities.PostFindingFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
class CommentCreatingService {

    private final CommentRepository commentRepository;
    private final PostFindingFacade postFindingFacade;
    private final PostBaseFunctionalitiesFacade postBaseFunctionalitiesFacade;

    @Transactional
    public ResponseEntity createComment(CreateCommentRequestDTO requestDTO) {

        CommentEntity commentEntity = new CommentEntity(requestDTO.getAuthor(), requestDTO.getContent(), requestDTO.getParentPostId());
        postBaseFunctionalitiesFacade.addCommmentToPost(commentEntity);
        commentRepository.save(commentEntity);

        CommentResponseDTO responseDTO = new CommentResponseDTO(requestDTO.getAuthor(), requestDTO.getContent());

        return new ResponseEntity(responseDTO, HttpStatus.CREATED);

    }

}
