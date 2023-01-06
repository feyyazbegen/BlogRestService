package com.LoginExam.LoginExample.response;

import lombok.Data;

@Data
public class CommentResponse {

    private Long id;
    private String text;
    private boolean isApproved;
    private UserResponse user;
}
