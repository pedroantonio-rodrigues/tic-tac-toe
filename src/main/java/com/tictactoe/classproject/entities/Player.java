package com.tictactoe.classproject.entities;

import com.tictactoe.classproject.entities.enums.PlayerStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PlayerStatus playerStatus;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String nickname;

	private String email;

	@Column(nullable = false)
	private String password;

	public Player() {

	}

	public Player(Long id, PlayerStatus playerStatus, String name, String nickname, String email, String password) {
		this.id = id;
		this.playerStatus = playerStatus;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}
	@OneToMany(mappedBy = "playerOne")
	private List<Match> gameAsPlayerOne;
	@OneToMany(mappedBy = "playerTwo")
	private List<Match> gameAsPlayerTwo;

	public List<Match> getMatches(){
		List<Match> matches = new ArrayList<>();
		matches.addAll(gameAsPlayerOne);
		matches.addAll(gameAsPlayerTwo);
		return matches;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PlayerStatus getPlayerStatus() {
		return playerStatus;
	}
	public void setPlayerStatus(PlayerStatus playerStatus) {
		this.playerStatus = playerStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return Objects.equals(id, player.id) && playerStatus == player.playerStatus && Objects.equals(name, player.name) && Objects.equals(nickname, player.nickname) && Objects.equals(email, player.email) && Objects.equals(password, player.password) && Objects.equals(gameAsPlayerOne, player.gameAsPlayerOne) && Objects.equals(gameAsPlayerTwo, player.gameAsPlayerTwo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, playerStatus, name, nickname, email, password, gameAsPlayerOne, gameAsPlayerTwo);
	}
}
