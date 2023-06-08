package com.tictactoe.classproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tictactoe.classproject.entities.Match;

public interface MatchRepository extends JpaRepository<Match,Long>{
    
}
