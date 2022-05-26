package com.maticendrak.socialmediaproject.content.contentfinder;

import com.maticendrak.socialmediaproject.content.post.dtos.responses.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ContentFindingController {

    private final ContentFindingFacade contentFindingFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/api/contentfinding/post/{username}")
    public ResponseEntity<List<PostResponseDTO>> findAllPostsOfRequestedAppUser(@PathVariable String username) {

        return contentFindingFacade.findAllPostsOfRequestedAppUser(username);

    }

}
