package com.LoginExam.LoginExample.response;

import lombok.Data;

@Data
public class PostResponse {

    private Long id;
    private String title;
    private String text;
    private boolean isApproved;
    private UserResponse user;

}
