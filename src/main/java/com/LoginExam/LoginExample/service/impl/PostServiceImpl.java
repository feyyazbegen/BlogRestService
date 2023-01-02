package com.LoginExam.LoginExample.service.impl;
import com.LoginExam.LoginExample.converter.PostConverter;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.repository.PostRepository;
import com.LoginExam.LoginExample.request.PostCreateRequest;
import com.LoginExam.LoginExample.service.PostService;
import com.LoginExam.LoginExample.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PostConverter postConverter;

    public PostServiceImpl(PostRepository postRepository, UserService userService, PostConverter postConverter) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.postConverter = postConverter;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createOnePost(PostCreateRequest request) {
        Optional<User> user = userService.getOneUserById(request.getUser_id());
        if (user == null){
            return null;
        }
        Post toSave = new Post();
        toSave.setId(request.getId());
        toSave.setText(request.getText());
        toSave.setTitle(request.getTitle());
        toSave.setCreated_at(new Date());
        toSave.setUser(user.get());
        return postRepository.save(toSave);
    }


}
