package com.tictactoe.classproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tictactoe.classproject.entities.BoardGame;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {
     
}
