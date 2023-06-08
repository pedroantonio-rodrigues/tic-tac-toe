package com.tictactoe.classproject.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "tb_match")
public class Match {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "playerOne_id")
	private Player playerOne;
	@OneToOne
	@JoinColumn(name = "playerTwo_id")
	private Player playerTwo;
	@OneToOne(mappedBy = "match")
	@JoinColumn(name = "board_game_id")
	private	BoardGame boardGame;
	private List<Position> moves;

	public Player getPlayerOne(){
		return playerOne;
	}

	public Player getPlayerTwo(){
		return playerTwo;
	}
	public void setPlayerOne(Player playerTwo){
		this.playerTwo = playerTwo;
	}
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	public void setMoves(ArrayList<Position> moves) {
		this.moves = moves;
	}
	public BoardGame getBoardGame(){
		return boardGame;
	}
	public void setBoardGame(BoardGame boardGame){
		this.boardGame = boardGame;
	}
	public Match makeMatch(Player playerOne, Player playerTwo){
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.boardGame = new BoardGame();
		this.moves = new ArrayList<>();
		return this;
	}

	// verified the current player
	public Object makeMove(Player player, int row, int column) throws Exception{
		if (!player.equals(getCurrentPlayer())){
			throw new Exception("Não é a vez do jogador.");
		}
		// create a position object on the move
		Position position = new Position(player, row, column);

		//verified if move is valid
		if (!position.isValidPosition(getBoardGame())) {
			throw new Exception("Jogada invalida.");
		}
		// realize the move
		String symbol = getPlayerPosition(player);
		position.makeMove(getBoardGame(), symbol);
		// add positions on list of moves
		moves.add(position);
		// verified if it has a winner
		if(checkWin(symbol)){
			return player;
		}
		// verified if it has a draw
		if (checkDraw()){
			return null;
		}
		// change the players
		switchPlayer();
		return player;
	}
	public Player getCurrentPlayer(){
		// verifies which player make next movement
		int totalMoves = moves.size();
		return totalMoves % 2 == 0 ? playerOne : playerTwo;
	}
	private	String getPlayerPosition(Player player){
		// define the symbol of player
		return player.equals(playerOne) ? "playerOne" : "playerTwo";
	}
	private void switchPlayer(){
		// change the players
		Player temp = playerOne;
		playerOne = playerTwo;
		playerTwo = temp;
	}
	private boolean checkWin(String player) {
	String[][] board = boardGame.getBoardGame();
		//verifies the possibilities of victory
		for (int i = 0; i < 3; i++){
			//verifies the lines
			if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)){
				return true;
			}
			// Verifies the columns
			if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
				return true;
			}
		}
		// Verifies de diagonals
		if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
			return true;
		}
		if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
			return true;
		}
		return false;
	}
	//check if it has a draw
	private boolean checkDraw() {
		String[][] board = boardGame.getBoardGame();
		for (String[] row : board) {
			for (String position : row) {
				if (position.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}



}
