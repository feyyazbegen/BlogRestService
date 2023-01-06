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
    private final CommentConverter commentConverter;

    public CommentServiceImpl(CommentRepository commentRepository, CommentConverter commentConverter) {
        this.commentRepository = commentRepository;
        this.commentConverter = commentConverter;
    }

    @Override
    public List<CommentResponse> getComments(Long postId) {
        List<Comment> byPostId = commentRepository.findByPostId(postId);
        if(byPostId.isEmpty()){
            throw new RuntimeException("İlgili Post bulunamadı");
        }
      return byPostId.stream().map(commentConverter::convertToCommentResponse).collect(Collectors.toList());
    }

    @Override
    public CommentResponse getCommentsWithPostIdAndCommentId(Long postId, Long commentId) {
        Comment byPostIdAndCommentId = commentRepository.findByPostIdAndCommentId(postId, commentId);
       return commentConverter.convertToCommentResponse(byPostIdAndCommentId);
    }
}
