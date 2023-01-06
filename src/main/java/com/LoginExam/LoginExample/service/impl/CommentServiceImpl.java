package com.LoginExam.LoginExample.service.impl;

import com.LoginExam.LoginExample.converter.CommentConverter;
import com.LoginExam.LoginExample.converter.PostConverter;
import com.LoginExam.LoginExample.entity.Comment;
import com.LoginExam.LoginExample.entity.Post;
import com.LoginExam.LoginExample.repository.CommentRepository;
import com.LoginExam.LoginExample.repository.PostRepository;
import com.LoginExam.LoginExample.response.CommentResponse;
import com.LoginExam.LoginExample.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentConverter commentConverter;
    private final PostConverter postConverter;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, CommentConverter commentConverter, PostConverter postConverter) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.commentConverter = commentConverter;
        this.postConverter = postConverter;
    }

    @Override
    public List<CommentResponse> getComments(Long postId) {
        List<Comment> byPostId = commentRepository.findByPostId(postId);
        if(byPostId.isEmpty()){
            throw new RuntimeException("İlgili Post bulunamadı");
        }
      return byPostId.stream().map(commentConverter::convertToCommentResponse).collect(Collectors.toList());
    }
}
