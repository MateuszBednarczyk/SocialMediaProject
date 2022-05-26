package com.maticendrak.socialmediaproject.content.contentcreator;

import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ContentCreatorController {

    private final ContentCreatorFacade contentCreatorFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/api/contentcreate/addnewpost")
    public void addNewPost(@RequestBody AddPostRequestDTO requestDTO) {

        contentCreatorFacade.addNewPost(requestDTO);

    }

}
