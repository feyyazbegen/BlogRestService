package com.LoginExam.LoginExample.service;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.request.PostCreateRequest;
import com.LoginExam.LoginExample.request.PostUpdateRequest;
import com.LoginExam.LoginExample.response.PostResponse;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post createOnePost(PostCreateRequest request);

    PostResponse getPost(Long postId);

    PostResponse updatePostById(Long postId, PostUpdateRequest request);
}
