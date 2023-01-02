package com.LoginExam.LoginExample.service;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.request.PostCreateRequest;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post createOnePost(PostCreateRequest request);
}
