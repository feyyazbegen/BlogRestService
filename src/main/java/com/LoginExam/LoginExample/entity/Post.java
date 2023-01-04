package com.LoginExam.LoginExample.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@SQLDelete(sql = "UPDATE posts SET is_deleted = true WHERE post_id=?")
@Where(clause = "is_deleted=false")
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

    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column(nullable = false,columnDefinition = "TINYINT(1)")
    private boolean isApproved;
    @Column(nullable = false,columnDefinition = "TINYINT(1)")
    private boolean isDeleted;

    @OneToMany(mappedBy = "post" )
    private Set<Comment> comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
