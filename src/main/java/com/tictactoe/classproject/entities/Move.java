package com.tictactoe.classproject.entities;

public abstract class Move {
	
	private Integer id;
	private Player player;
	private Position position;
	
	public Move(){

	}
	public Move(Integer id, Player player,  Position position) {
		this.id = id;
		this.player = player;
		this.position = position;	
	}

	
	public Integer geId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
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
