package com.example.boardproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {
    private final ArticleService articleService;
    private final BoardService boardService;

//    @GetMapping("view")
//    public String view(Model model) {
//        model.addAttribute("articles", articleService.readArticleAll());
//        return "article/list1";
//    }

    @GetMapping("/boardId/article")
    public String writeView(Model model){
        model.addAttribute("boards",boardService.readBoardAll());
        return "article/write";
    }

    @PostMapping("/write")
    public String write(
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("password")
            String password,
            @RequestParam("board-id")
            Long boardId
    ) {
        articleService.create(title,content, password, boardId);
        return "redirect:/article";
    }
    @GetMapping
    public String readAll(Model model){
        model.addAttribute("articles", articleService.readArticleAll());
        return "article/list1";
    }

    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article", articleService.readArticle(id));
        return "article/read";
    }

    @GetMapping("{id}/update-view")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article",articleService.readArticle(id));
        model.addAttribute("boards", boardService.readBoardAll());
        return "article/update";
    }

    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("board-id")
            Long boardId
    ) {
        articleService.update(id,title,content,boardId);
        return String.format("redirect:/article/%d",id);

    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        articleService.delete(id);
        return "redirect:/article";

    }
}
