package com.maticendrak.socialmediaproject.appuser.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@Immutable
public class SendMailRequestDTO {

    String username;
    String title;

    @Nullable
    String content;
    String directionMail;

}
