package com.LoginExam.LoginExample.service;


import com.LoginExam.LoginExample.response.CommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getComments(Long postId);

    CommentResponse getCommentsWithParam(Long postId, Long commentId);
}
