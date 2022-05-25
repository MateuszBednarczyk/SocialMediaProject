package com.maticendrak.socialmediaproject.content.post.basefunctionalities;

import com.maticendrak.socialmediaproject.content.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFindingService {

    private final PostRepository postRepository;

}
