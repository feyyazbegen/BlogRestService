package com.LoginExam.LoginExample.repository;

import com.LoginExam.LoginExample.entity.Comment;
import com.LoginExam.LoginExample.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select * from comment where post_id=:postId",nativeQuery = true)
    List<Comment> findByPostId(Long postId);
}
