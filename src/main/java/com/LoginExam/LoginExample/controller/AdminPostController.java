package com.LoginExam.LoginExample.controller;
import com.LoginExam.LoginExample.response.PostResponse;
import com.LoginExam.LoginExample.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/posts")
public class AdminPostController {

    private final PostService postService;

    public AdminPostController(PostService postService) {
        this.postService = postService;
    }

    @PutMapping("/{postId}/approve")
    public PostResponse approvePost(@PathVariable Long postId){
       return postService.approvePost(postId);
    }
}
