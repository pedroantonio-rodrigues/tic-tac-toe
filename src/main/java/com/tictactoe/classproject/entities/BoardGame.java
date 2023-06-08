package com.tictactoe.classproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_boardGame")
public class BoardGame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "boardGame")
	private Match match;
	private String[][] boardGame = {
			{"", "", ""},
			{"", "", ""},
			{"", "", ""}
	};
	public Long getId(){
		return id;
	}
	public Match getMatch(){
		return match;
	}
	public void setMatch(Match match){
		this.match = match;
	}
	public String[][] getBoardGame(){
		return boardGame;
	}
	public boolean isPositionEmpty(int row, int column){
		return boardGame[row][column].isEmpty();
	}
	public void makeMove(int row, int column,String player){
		boardGame[row][column] = player;
	}

	}

