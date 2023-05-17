package com.tictactoe.classproject.entities;

public abstract class Move {
	
	private Player player;
	private Position position;
	
	public Move(Player player,  Position position) {
		this.player = player;
		this.position = position;	
	}
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}
