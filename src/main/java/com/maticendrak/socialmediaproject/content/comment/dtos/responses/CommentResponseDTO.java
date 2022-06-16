package com.maticendrak.socialmediaproject.content.comment.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class CommentResponseDTO {

    String author;
    String content;

}
