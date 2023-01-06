package com.LoginExam.LoginExample.converter;

import com.LoginExam.LoginExample.entity.Comment;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.response.CommentResponse;
import com.LoginExam.LoginExample.response.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    private final UserConverter userConverter;

    public CommentConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public CommentResponse convertToCommentResponse(Comment comment){
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getId());
        commentResponse.setText(comment.getText());
        commentResponse.setApproved(comment.isApproved());
        commentResponse.setUser(userConverter.convertToUserResponse(comment.getUser()));
        return commentResponse;
    }
}
