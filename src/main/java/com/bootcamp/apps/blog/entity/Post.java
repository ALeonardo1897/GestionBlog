package com.bootcamp.apps.blog.entity;

import lombok.Cleanup;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private String content;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @PrePersist
    protected void prePersist(){
        this.date = new Date();
    }
}
