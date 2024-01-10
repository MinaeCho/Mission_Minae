package com.example.boardproject;

import com.example.boardproject.entity.Comment;
import com.example.boardproject.repo.ArticleRepository;
import com.example.boardproject.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public void create(
            Long articleId,
            String content
    ){
       Comment comment = new Comment();
       comment.setContent(content);
       commentRepository.save(comment);

    }
}
