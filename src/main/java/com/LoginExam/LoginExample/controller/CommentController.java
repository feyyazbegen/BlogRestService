package com.LoginExam.LoginExample.controller;
import com.LoginExam.LoginExample.request.CommentUpdateRequest;
import com.LoginExam.LoginExample.response.CommentResponse;
import com.LoginExam.LoginExample.service.CommentService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{postId}/comment/{commentId}")
    public CommentResponse updateWithPostIdAndCommentId(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateWithPostIdAndCommentId(postId,commentId,request);
    }

}
