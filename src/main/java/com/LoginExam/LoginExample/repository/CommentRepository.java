package com.LoginExam.LoginExample.repository;

import com.LoginExam.LoginExample.entity.Comment;
import com.LoginExam.LoginExample.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select * from comment where post_id=:postId",nativeQuery = true)
    List<Comment> findByPostId(Long postId);

    @Query(value = "select * from comment where post_id=:postId and comment_id=:commentId",nativeQuery = true)
    Comment findByPostIdAndCommentId(Long postId, Long commentId);

    @Query(value = "select * from comment where comment_id=:commentId and is_approved=:isApproved",nativeQuery = true)
    Optional<Comment> findByCommentIdAndApproved(Long commentId,boolean isApproved);
}
