package com.example.boardproject.controller;

import com.example.boardproject.service.ArticleService;
import com.example.boardproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("boards", boardService.readBoardAll());
        return "board/home";
    }

    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("board",boardService.readBoard(id));
        return "board/read";
    }

}
