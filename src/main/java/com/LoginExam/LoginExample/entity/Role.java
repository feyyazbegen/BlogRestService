package com.LoginExam.LoginExample.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "roles")
@Data
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
