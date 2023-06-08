package com.tictactoe.classproject.services;

import com.tictactoe.classproject.entities.Position;
import com.tictactoe.classproject.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository repository;
    @Autowired
    public PositionService (PositionRepository repository){
        this.repository = repository;
    }

    public List<Position> findAll(){
        return repository.findAll();
    }
}
