package com.LoginExam.LoginExample.controller;

import com.LoginExam.LoginExample.response.CommentResponse;
import com.LoginExam.LoginExample.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/comments")
public class AdminCommentController {

    private final CommentService commentService;

    public AdminCommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PutMapping("/{commentId}/approve")
    public CommentResponse approveComment(@PathVariable Long commentId){
        return commentService.approveComment(commentId);
    }

    @PutMapping("/{commentId}/unApprove")
    public CommentResponse unApproveComment(@PathVariable Long commentId){
        return commentService.unApproveComment(commentId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }
}
