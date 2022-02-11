package com.bootcamp.apps.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date date;

    @Column
    private String name;

    @Column
    private CommentStatus status;

    @ManyToOne
    private Post post;
}
