package com.tictactoe.classproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.classproject.entities.BoardGame;
import com.tictactoe.classproject.repositories.BoardGameRepository;

@Service
public class BoardGameService {

    @Autowired
    private BoardGameRepository repository;

    public List<BoardGame> findAll() {
        return repository.findAll();
    }

    public BoardGame findById(Integer id) {
        Optional<BoardGame> obj = repository.findById(id);
        return obj.get();
    }

}
