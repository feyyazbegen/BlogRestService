package com.LoginExam.LoginExample.converter;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.response.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public PostResponse convertToPostResponse(Post post){
        PostResponse postResponse = new PostResponse(post);
        return postResponse;
    }

}
