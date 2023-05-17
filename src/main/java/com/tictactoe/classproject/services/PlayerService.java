package com.tictactoe.classproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.classproject.entities.Player;
import com.tictactoe.classproject.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
    private PlayerRepository repository;

    public List<Player> findAll(){
        return repository.findAll();
    }

    public Player findById(Integer id){
        Optional<Player> obj = repository.findById(id);
        return obj.get();
    }
    public Player insert(Player obj){
        return repository.save(obj);
    }

}
