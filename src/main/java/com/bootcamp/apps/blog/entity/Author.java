package com.bootcamp.apps.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "author",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs;

}
