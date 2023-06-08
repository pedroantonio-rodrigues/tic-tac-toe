package com.tictactoe.classproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tictactoe.classproject.entities.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long>{

    List<Player> findByNicknameOrEmail(String nickname, String email);

    void deleteById(Long playerId);
}