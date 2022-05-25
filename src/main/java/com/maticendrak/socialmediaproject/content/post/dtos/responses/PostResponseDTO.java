package com.maticendrak.socialmediaproject.content.post.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class PostResponseDTO {

    String author;
    String postTitle;
    String postContent;

}
