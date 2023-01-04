package com.LoginExam.LoginExample.service.impl;
import com.LoginExam.LoginExample.converter.PostConverter;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.repository.PostRepository;
import com.LoginExam.LoginExample.request.PostCreateRequest;
import com.LoginExam.LoginExample.request.PostUpdateRequest;
import com.LoginExam.LoginExample.response.PostResponse;
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
        Optional<User> user = userService.getOneUserById(request.getUserId());
        if (!user.isPresent()) {
            return null;
        }
        Post toSave = new Post();
        toSave.setText(request.getText());
        toSave.setTitle(request.getTitle());
        toSave.setCreatedAt(new Date());
        toSave.setUser(user.get());
        return postRepository.save(toSave);
    }

    @Override
    public PostResponse getPost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            throw new RuntimeException("Post Bulunamadı");
        }
        return postConverter.convertToPostResponse(post.get());
    }

    @Override
    public PostResponse updatePostById(Long postId, PostUpdateRequest request) {
        Optional<Post> byId = postRepository.findById(postId);
        if (!byId.isPresent()) {
            throw new RuntimeException("Post Bulunamadı");
        }
        Post post = byId.get();
        post.setText(request.getText());
        post.setTitle(request.getTitle());
        postRepository.save(post);
        return postConverter.convertToPostResponse(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostResponse approvePost(Long postId) {
        Optional<Post> optionalPost = postRepository.findByIdAndApproved(postId,false);
        if (!optionalPost.isPresent()) {
            throw new RuntimeException("Post Bulunamadı");
        }
        Post post = optionalPost.get();
        post.setApproved(true);
        postRepository.save(post);
        return postConverter.convertToPostResponse(post);
    }


}
