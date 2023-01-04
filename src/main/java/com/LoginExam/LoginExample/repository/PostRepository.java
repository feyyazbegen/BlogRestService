package com.LoginExam.LoginExample.repository;
import com.LoginExam.LoginExample.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "select * from posts where post_id=:id and is_approved=:isApproved",nativeQuery = true)
    Optional<Post> findByIdAndApproved(Long id,boolean isApproved);
}
