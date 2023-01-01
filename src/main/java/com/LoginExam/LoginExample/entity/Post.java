package com.LoginExam.LoginExample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long Id;
    private String title;
    @Lob
    @Column(columnDefinition = "text")
    private String text;

    private Date created_at;
    private Date updated_at;

    private boolean isApproved;
    private boolean isDeleted;

    @OneToMany(mappedBy = "post" )
    private Set<Comment> comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
