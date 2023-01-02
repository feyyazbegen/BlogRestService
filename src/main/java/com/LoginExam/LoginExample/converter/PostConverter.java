package com.LoginExam.LoginExample.converter;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.response.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    private final UserConverter userConverter;
    public PostConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public PostResponse convertToPostResponse(Post post){
        PostResponse postResponse = new PostResponse();
        postResponse.setId(post.getId());
        postResponse.setText(post.getText());
        postResponse.setTitle(post.getTitle());
        postResponse.setUser(userConverter.convertToUserResponse(post.getUser()));
        return postResponse;
    }

}
