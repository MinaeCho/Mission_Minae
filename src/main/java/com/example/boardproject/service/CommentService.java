package com.example.boardproject.service;

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
            String content,
            Long articleId
    ){
        Comment comment = new Comment();
        comment.setContent(content);

        comment.setArticle(articleRepository.findById(articleId).orElse(null));
        commentRepository.save(comment);

    }

    public void delete(Long id) {commentRepository.deleteById(id);}

}

