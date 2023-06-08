package com.tictactoe.classproject.services;

import java.util.ArrayList;
import java.util.List;

import com.tictactoe.classproject.entities.BoardGame;
import com.tictactoe.classproject.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.classproject.entities.Match;
import com.tictactoe.classproject.repositories.MatchRepository;

@Service
public class MatchService {


    private MatchRepository repository;

    public Match createMatch(Player playerOne, Player playerTwo){
        Match match = new Match();
        match.setPlayerOne(playerOne);
        match.setPlayerTwo(playerTwo);
        match.setBoardGame(new BoardGame());
        match.setMoves(new ArrayList<>());

        return repository.save(match);
    }
    public Match updateMatch(Long id, int row, int column) throws Exception{
        Match match = repository.findById(id).orElseThrow(() -> new RuntimeException("Partida não encontrada"));

        Player currentPlayer = match.getCurrentPlayer();
        match.makeMove(currentPlayer, row, column);

        return repository.save(match);
    }

    public List<Match> findAll() {
        return repository.findAll();
    }



}
