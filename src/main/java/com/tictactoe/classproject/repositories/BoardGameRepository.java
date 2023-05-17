package com.tictactoe.classproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tictactoe.classproject.entities.BoardGame;

public interface BoardGameRepository extends JpaRepository<BoardGame, Integer> {
     
}
