package com.example.boardproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String password;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "article")
//    @OrderBy("id desc")
    private List<Comment> comments = new ArrayList<>();
}
