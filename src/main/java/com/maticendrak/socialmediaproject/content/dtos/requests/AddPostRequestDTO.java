package com.maticendrak.socialmediaproject.content.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class AddPostRequestDTO {

    String username;
    String postTitle;
    String postContent;

}
