package com.tictactoe.classproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.classproject.entities.Match;
import com.tictactoe.classproject.services.MatchService;

@RestController
@RequestMapping(value = "/match")
public class MatchResource {
    
    @Autowired
    private MatchService service;

    @GetMapping
    public ResponseEntity<List<Match>> findAll(){
        List<Match> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
