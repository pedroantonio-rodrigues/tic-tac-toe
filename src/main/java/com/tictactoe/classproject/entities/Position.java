package com.tictactoe.classproject.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Player player;

	private int row;
	private int column;

	public Position(){
	}
	public Position(Player player, int row, int column) {
		this.player = player;
		this.row = row;
		this.column = column;
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player){
		this.player = player;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row){
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column){
		this.column = column;
	}
	// valid position
	public boolean isValidPosition(BoardGame boardGame){
		return boardGame.isPositionEmpty(row, column);
	}// make a move
	public void makeMove(BoardGame boardGame, String symbol){
		boardGame.makeMove(row, column, symbol);
	}
}