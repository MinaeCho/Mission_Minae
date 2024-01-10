package com.example.boardproject;

import com.example.boardproject.entity.Article;
import com.example.boardproject.repo.ArticleRepository;
import com.example.boardproject.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

    public void create(
            String title,
            String content,
            String password,
            Long boardId
    ){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setPassword(password);
        article.setBoard(boardRepository.findById(boardId).orElse(null));
        articleRepository.save(article);
    }

    public Article readArticle(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }

    public List<Article> readArticleAll()
    {return articleRepository.findAll();}


    public void update(
            Long id,
            String title,
            String content,
            Long boardId
    ) {
        Article target = readArticle(id);
        target.setTitle(title);
        target.setContent(content);
        target.setBoard(boardRepository.findById(boardId).orElse(null));

        articleRepository.save(target);
    }

    public void delete(Long id) {articleRepository.deleteById(id);}

}

