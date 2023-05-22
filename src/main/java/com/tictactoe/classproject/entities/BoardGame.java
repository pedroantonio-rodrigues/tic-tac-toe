package com.tictactoe.classproject.entities;

import java.util.HashMap;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_boardGame")
public class BoardGame {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 

	@ElementCollection
	private HashMap<String, Character> board;

	public BoardGame() {
		board = new HashMap<String, Character>();
		startBoardGame();
	}

	private void startBoardGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String key = Integer.toString(i) + Integer.toString(j);
				board.put(key, '-');
			}
		}
	}
	
	public Player currentPlayer() {
		int numMoves = getNumMoves();
		if(numMoves % 2 == 0) {
			return getPlayerOne(Player.class);
		}else {
			return getPlayerTwo(Player.class);
		}
	}
	
	private Player getPlayerTwo(Class<Player> class1) {
		return null;
	}

	private Player getPlayerOne(Class<Player> class1) {
		return null;
	}

	private int getNumMoves() {
		return 0;
	}

	public boolean fullBoardGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String key = Integer.toString(i) + Integer.toString(j);
				if (board.get(key) == '-') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean rowsForWin() {
		for (int i = 0; i < 3; i++) {
			String key1 = Integer.toString(i) + Integer.toString(0);
			String key2 = Integer.toString(i) + Integer.toString(1);
			String key3 = Integer.toString(i) + Integer.toString(2);
			if (rowColumn(board.get(key1), board.get(key2), board.get(key3))) {
				return true;
			}
		}
		return false;
	}

	public boolean columnsForWin() {
		for (int i = 0; i < 3; i++) {
			String key1 = Integer.toString(i) + Integer.toString(0);
			String key2 = Integer.toString(i) + Integer.toString(1);
			String key3 = Integer.toString(i) + Integer.toString(2);
			if (rowColumn(board.get(key1), board.get(key2), board.get(key3))) {
				return true;
			}
		}
		return false;
	}

	public boolean diagonalForWin() {
		String key1 = Integer.toString(0) + Integer.toString(0);
		String key2 = Integer.toString(1) + Integer.toString(1);
		String key3 = Integer.toString(2) + Integer.toString(2);
		if (rowColumn(board.get(key1), board.get(key2), board.get(key3))) {
			return true;
		}
		key1 = Integer.toString(2) + Integer.toString(0);
		key1 = Integer.toString(0) + Integer.toString(2);
		if (rowColumn(board.get(key1), board.get(key2), board.get(key3))) {
			return true;
		}
		return false;
	}

	private boolean rowColumn(Character c1, Character c2, Character c3) {
		return (c1 != '-' && c1 == c2 && c2 == c3);
	}

	}

