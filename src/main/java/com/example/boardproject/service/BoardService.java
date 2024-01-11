package com.example.boardproject.service;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService{
    private final BoardRepository boardRepository;

        public List<Board> readBoardAll() {
            return boardRepository.findAll();
        }

        public Board readBoard(Long id) {
            return boardRepository.findById(id).orElse(null);

        }

}
