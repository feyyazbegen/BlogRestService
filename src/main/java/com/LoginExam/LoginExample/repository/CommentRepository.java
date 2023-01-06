package com.LoginExam.LoginExample.repository;

import com.LoginExam.LoginExample.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select * from comment where post_id=:postId and is_approved=:isApproved and is_deleted=:isDeleted",nativeQuery = true)
    List<Comment> findByPostIdAndApprovedAndDeleted(Long postId, boolean isApproved, boolean isDeleted);

    @Query(value = "select * from comment where post_id=:postId and comment_id=:commentId and is_approved=:isApproved " +
            "and is_deleted=:isDeleted ",nativeQuery = true)
    Comment findByPostIdAndCommentId(Long postId, Long commentId,boolean isApproved, boolean isDeleted);

    @Query(value = "select * from comment where comment_id=:commentId and is_approved=:isApproved",nativeQuery = true)
    Optional<Comment> findByCommentIdAndApproved(Long commentId,boolean isApproved);
}
