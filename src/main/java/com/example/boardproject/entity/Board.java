package com.example.boardproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    @OneToMany(mappedBy = "board")

    private List<Article> writtenArticles = new ArrayList<>();
}
