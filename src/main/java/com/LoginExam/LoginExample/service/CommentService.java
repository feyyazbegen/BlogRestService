package com.LoginExam.LoginExample.service;


import com.LoginExam.LoginExample.request.CommentUpdateRequest;
import com.LoginExam.LoginExample.response.CommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getComments(Long postId);

    CommentResponse getCommentsWithPostIdAndCommentId(Long postId, Long commentId);


    CommentResponse updateWithPostIdAndCommentId(Long postId, Long commentId, CommentUpdateRequest request);

    CommentResponse approveComment(Long commentId);
}
