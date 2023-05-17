package com.tictactoe.classproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tictactoe.classproject.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}