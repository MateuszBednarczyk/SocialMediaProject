package com.maticendrak.socialmediaproject.content.post;

import com.maticendrak.socialmediaproject.content.post.basefunctionalities.PostBaseFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.AddPostRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.UpdatePostContentRequestDTO;
import com.maticendrak.socialmediaproject.content.post.dtos.requests.UpdatePostTitleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class PostContentController {

    private final PostBaseFunctionalitiesFacade postBaseFunctionalitiesFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/api/content/addnewpost")
    public void addNewPost(@RequestBody AddPostRequestDTO requestDTO) {

        postBaseFunctionalitiesFacade.addNewPost(requestDTO);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/content/deletepost")
    public void deletePostById(@RequestParam Long postId) {

        postBaseFunctionalitiesFacade.deletePostById(postId);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/content/updatepostcontent")
    public ResponseEntity updatePostContent(@RequestBody UpdatePostContentRequestDTO requestDTO) {

        return postBaseFunctionalitiesFacade.updatePostContent(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/content/updateposttitle")
    public ResponseEntity updatePostTitle (@RequestBody UpdatePostTitleRequestDTO requestDTO) {

        return postBaseFunctionalitiesFacade.updatePostTitle(requestDTO);

    }


}
