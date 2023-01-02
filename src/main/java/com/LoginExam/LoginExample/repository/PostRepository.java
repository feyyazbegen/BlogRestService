package com.LoginExam.LoginExample.repository;
import com.LoginExam.LoginExample.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
