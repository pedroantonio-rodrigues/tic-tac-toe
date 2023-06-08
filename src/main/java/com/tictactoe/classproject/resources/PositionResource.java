package com.tictactoe.classproject.resources;

import com.tictactoe.classproject.entities.Position;
import com.tictactoe.classproject.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/position")
public class PositionResource {
    private final PositionService service;

    @Autowired
    private PositionResource (PositionService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Position>> findAll() {
        List<Position> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
