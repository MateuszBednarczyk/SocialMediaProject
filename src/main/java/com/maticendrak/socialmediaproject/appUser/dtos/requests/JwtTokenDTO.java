package com.maticendrak.socialmediaproject.appUser.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
@ToString
public class JwtTokenDTO {

    String token;

}
