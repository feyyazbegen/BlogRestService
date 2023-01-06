package com.LoginExam.LoginExample.controller;

import com.LoginExam.LoginExample.response.CommentResponse;
import com.LoginExam.LoginExample.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/comments")
public class AdminCommentController {

    private final CommentService commentService;

    public AdminCommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PutMapping("/{commentId}/approve")
    public CommentResponse approvePost(@PathVariable Long commentId){
        return commentService.approveComment(commentId);
    }
}
