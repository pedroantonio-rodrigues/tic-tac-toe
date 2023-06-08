package com.tictactoe.classproject.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tictactoe.classproject.entities.Player;
import com.tictactoe.classproject.repositories.PlayerRepository;

@Service
public class PlayerService {
	private static String name;
    private static String email;
    private static String nickname;
    private static String password;

    @Autowired
    private PlayerRepository repository;

    public void prepare(String name, String email, String nickname, String password){
        PlayerService.name = name;
        PlayerService.email = email;
        PlayerService.nickname = nickname;
        PlayerService.password = password;
    }
    public Player execute(){
        if (validPlayerExistsNicknameOrEmail()){
            throw new RuntimeException("Não é possivel criar um nickname repitido.");
        }
        Player player = new Player();
        player.setName(name);
        player.setNickname(nickname);
        player.setEmail(email);
        player.setPassword(password);

        player = repository.save(player);

        return player;
    }
    public boolean validPlayerExistsNicknameOrEmail(){
        List<Player> players = repository.findByNicknameOrEmail(nickname, email);
        return !players.isEmpty();
    }

    public Object getAllPlayers() {
        return repository.findAll();
    }

    public Player createPlayer(Player player) {
        return repository.save(player);
    }
    public Player updatePlayer(Long id, Player player) {
        return repository.save(player);
    }

    public void deletePlayer(Long id) {
        repository.deleteById(id);
    }

    public Player getPlayerById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
