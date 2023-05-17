package com.tictactoe.classproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.classproject.entities.Match;
import com.tictactoe.classproject.repositories.MatchRepository;

@Service
public class MatchService {

    @Autowired
    private MatchRepository repository;

    public List<Match> findAll() {
        return repository.findAll();
    }


}
