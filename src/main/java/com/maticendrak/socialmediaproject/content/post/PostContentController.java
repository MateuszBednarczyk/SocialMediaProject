package com.maticendrak.socialmediaproject.content.post;

import com.maticendrak.socialmediaproject.content.post.basefunctionalities.PostBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class PostContentController {

    private final PostBaseFunctionalitiesFacade postBaseFunctionalitiesFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/api/contentcreate/addnewpost")
    public void addNewPost(@RequestBody AddPostRequestDTO requestDTO) {

        postBaseFunctionalitiesFacade.addNewPost(requestDTO);

    }

}
