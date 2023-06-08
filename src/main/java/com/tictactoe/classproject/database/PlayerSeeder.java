package com.tictactoe.classproject.database;

import com.tictactoe.classproject.entities.Player;
import com.tictactoe.classproject.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlayerSeeder implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerSeeder(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args){
        seedPlayer();
    }
    private void seedPlayer(){
        for (int i = 1; i <= 10; i++){
            Player player = new Player();
            player.setName("Player " + i);
            player.setNickname("Playernickname" + i);
            player.setEmail("Player" + i + "@email.com");

            playerRepository.save(player);

        }
    }
}
