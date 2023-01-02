package com.LoginExam.LoginExample.controller;

import com.LoginExam.LoginExample.converter.PostConverter;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.request.PostCreateRequest;
import com.LoginExam.LoginExample.response.PostResponse;
import com.LoginExam.LoginExample.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final PostConverter postConverter;

    public PostController(PostService postService, PostConverter postConverter) {
        this.postService = postService;
        this.postConverter = postConverter;
    }

    @GetMapping("/")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts().stream().map(postConverter::convertToPostResponse).toList();
    }
    @PostMapping("/")
    public Post createOnePost(@RequestBody PostCreateRequest request){
        return postService.createOnePost(request);
    }

}