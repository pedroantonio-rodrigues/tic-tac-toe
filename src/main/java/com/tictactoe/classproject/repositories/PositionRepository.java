package com.tictactoe.classproject.repositories;

import com.tictactoe.classproject.entities.Player;
import com.tictactoe.classproject.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
