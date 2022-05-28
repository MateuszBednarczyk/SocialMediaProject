package com.maticendrak.socialmediaproject.content.post;

import com.maticendrak.socialmediaproject.content.post.dtos.responses.PostResponseDTO;
import com.maticendrak.socialmediaproject.content.post.findingpostsfunctionalities.PostFindingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class PostFindingController {

    private final PostFindingFacade postFindingFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/api/contentfinding/post/{username}")
    public ResponseEntity<List<PostResponseDTO>> findAllPostsOfRequestedAppUser(@PathVariable String username) {

        return postFindingFacade.findAllPostsOfRequestedAppUser(username);

    }

}
