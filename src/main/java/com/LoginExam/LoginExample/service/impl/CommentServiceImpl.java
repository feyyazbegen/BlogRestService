package com.LoginExam.LoginExample.service.impl;

import com.LoginExam.LoginExample.converter.CommentConverter;
import com.LoginExam.LoginExample.entity.Comment;
import com.LoginExam.LoginExample.repository.CommentRepository;
import com.LoginExam.LoginExample.request.CommentUpdateRequest;
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
        List<Comment> byPostId = commentRepository.findByPostIdAndApprovedAndDeleted(postId,true,false);
        if(byPostId.isEmpty()){
            throw new RuntimeException("İlgili Yorum bulunamadı");
        }
      return byPostId.stream().map(commentConverter::convertToCommentResponse).collect(Collectors.toList());
    }

    @Override
    public CommentResponse getCommentsWithPostIdAndCommentId(Long postId, Long commentId) {
        Comment byPostIdAndCommentId = commentRepository.findByPostIdAndCommentId(postId, commentId,true,false);
       return commentConverter.convertToCommentResponse(byPostIdAndCommentId);
    }

    @Override
    public CommentResponse updateWithPostIdAndCommentId(Long postId, Long commentId, CommentUpdateRequest request) {
        Comment byPostIdAndCommentId = commentRepository.findByPostIdAndCommentId(postId, commentId,true,false);
        byPostIdAndCommentId.setText(request.getText());
        commentRepository.save(byPostIdAndCommentId);
        return commentConverter.convertToCommentResponse(byPostIdAndCommentId);
    }

    @Override
    public CommentResponse approveComment(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findByCommentIdAndApproved(commentId, false);
        if (!optionalComment.isPresent()){
            throw new RuntimeException("İlgili Yorum Bulunamadı");
        }
        Comment comment = optionalComment.get();
        comment.setApproved(true);
        commentRepository.save(comment);
        return commentConverter.convertToCommentResponse(comment);
    }

    @Override
    public CommentResponse unApproveComment(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findByCommentIdAndApproved(commentId, true);
        if (!optionalComment.isPresent()){
            throw new RuntimeException("İlgili Yorum Bulunamadı");
        }
        Comment comment = optionalComment.get();
        comment.setApproved(false);
        commentRepository.save(comment);
        return commentConverter.convertToCommentResponse(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
