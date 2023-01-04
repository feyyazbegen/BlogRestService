package com.LoginExam.LoginExample.controller;

import com.LoginExam.LoginExample.converter.PostConverter;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.request.PostCreateRequest;
import com.LoginExam.LoginExample.request.PostUpdateRequest;
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
    public PostResponse createOnePost(@RequestBody PostCreateRequest request) {
        Post onePost = postService.createOnePost(request);
        return postConverter.convertToPostResponse(onePost);
    }

    @GetMapping("/{postId}")
    public PostResponse getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @PutMapping("/{postId}")
    public PostResponse updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        return postService.updatePostById(postId, request);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }



}