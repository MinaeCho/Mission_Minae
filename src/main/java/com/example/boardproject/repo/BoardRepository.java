package com.example.boardproject.repo;

import com.example.boardproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository  extends JpaRepository<Board, Long>  {
}
