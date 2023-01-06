package com.LoginExam.LoginExample.controller;
import com.LoginExam.LoginExample.response.CommentResponse;
import com.LoginExam.LoginExample.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/post")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{postId}/comment")
    public List<CommentResponse> getComments(@PathVariable Long postId){
        return commentService.getComments(postId);
    }
    @GetMapping("/{postId}/comment/{commentId}")
    public CommentResponse getCommentsWithPostIdAndCommentId(@PathVariable Long postId,@PathVariable Long commentId){
        return commentService.getCommentsWithPostIdAndCommentId(postId,commentId);
    }
}
