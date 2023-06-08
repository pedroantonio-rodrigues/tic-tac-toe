package com.tictactoe.classproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tictactoe.classproject.entities.BoardGame;
import com.tictactoe.classproject.services.BoardGameService;

@RestController
@RequestMapping(value = "/boardgame")
public class BoardGameResource {

    private final BoardGameService service;
    @Autowired
    private BoardGameResource (BoardGameService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<BoardGame>> findAll() {
        List<BoardGame> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BoardGame> findById(@PathVariable Long id) {
        BoardGame obj = service.findById(id);
        if (obj != null) {
            return ResponseEntity.ok().body(obj);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping ResponseEntity<BoardGame> save(@RequestBody BoardGame boardGame){
        BoardGame saveBoardGame = service.save(boardGame);
        return ResponseEntity.ok().body(saveBoardGame);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
