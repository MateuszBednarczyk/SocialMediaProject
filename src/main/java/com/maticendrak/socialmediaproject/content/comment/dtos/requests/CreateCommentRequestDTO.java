package com.maticendrak.socialmediaproject.content.comment.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class CreateCommentRequestDTO {

    Long parentPostId;
    String author;
    String content;

}
