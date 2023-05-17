package com.tictactoe.classproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tictactoe.classproject.entities.BoardGame;
import com.tictactoe.classproject.services.BoardGameService;

@RestController
@RequestMapping(value = "/boardgame")
public class BoardGameResource {

    @Autowired
    private BoardGameService service;

    @GetMapping
    public ResponseEntity<List<BoardGame>> findAll() {
        List<BoardGame> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BoardGame> findById(@PathVariable Integer id) {
        BoardGame obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
