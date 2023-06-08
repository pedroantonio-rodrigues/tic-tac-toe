package com.tictactoe.classproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.classproject.entities.BoardGame;
import com.tictactoe.classproject.repositories.BoardGameRepository;

@Service
public class BoardGameService {

    private final BoardGameRepository repository;
    @Autowired
    public BoardGameService (BoardGameRepository repository){
        this.repository = repository;
    }

    public List<BoardGame> findAll() {
        return repository.findAll();
    }

    public BoardGame findById(Long id) {
        Optional<BoardGame> optionalBoardGame = repository.findById(id);
        return optionalBoardGame.orElse(null);
    }
    public BoardGame save(BoardGame boardGame){
        return repository.save(boardGame);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
