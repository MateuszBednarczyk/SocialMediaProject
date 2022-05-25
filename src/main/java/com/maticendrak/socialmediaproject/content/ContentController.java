package com.maticendrak.socialmediaproject.content;

import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentFacade contentFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/api/addnewpost")
    public void addNewPost(@RequestBody AddPostRequestDTO requestDTO) {

        contentFacade.addNewPost(requestDTO);

    }

}
