package com.maticendrak.socialmediaproject.content.post.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class UpdatePostTitleRequestDTO {

    Long postId;
    String newTitle;

}
