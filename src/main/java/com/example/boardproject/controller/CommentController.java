package com.example.boardproject.controller;

import com.example.boardproject.service.ArticleService;
import com.example.boardproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("article/{articleId}/comment")
public class CommentController {
    private final ArticleService articleService;
    private final CommentService commentService;

    @PostMapping
    public String create(
            @PathVariable("articleId")
            Long articleId,
            @RequestParam("content")
            String content

    ) {
        commentService.create(content, articleId);
        return String.format("redirect:/article/%d", articleId);
    }
    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        commentService.delete(id);
        return "redirect:/article";

    }
}
