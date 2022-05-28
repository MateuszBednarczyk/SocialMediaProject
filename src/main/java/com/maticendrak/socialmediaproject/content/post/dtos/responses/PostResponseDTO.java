package com.maticendrak.socialmediaproject.content.post.dtos.responses;

import com.maticendrak.socialmediaproject.content.comment.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.util.Set;

@Getter
@AllArgsConstructor
@Immutable
public class PostResponseDTO {

    Long postId;
    String authorUsername;
    String postTitle;
    String postContent;
    Set<CommentEntity> postComments;

}
