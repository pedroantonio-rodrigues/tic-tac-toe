package com.tictactoe.classproject.entities;

import java.time.Instant;

import com.tictactoe.classproject.entities.enums.MatchStatus;

public class Match {

	private Integer id;
	private Instant startedGame;
	private Instant finishedGame;

	private BoardGame boardGame;

	private Player playerOne;
	private Player playerTwo;

	private Integer matchStatus;

	public Match() {
	}

	public Match(Integer id, Instant startedGame, Instant finishedGame, BoardGame boardGame, Player playerOne,
			Player playerTwo, MatchStatus matchStatus) {
		this.id = id;
		this.startedGame = Instant.now();
		this.finishedGame = finishedGame;
		this.boardGame = boardGame;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;

		setMatchStatus(matchStatus);
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getStartedGame() {
		return startedGame;
	}

	public void setStartedGame(Instant startedGame) {
		this.startedGame = startedGame;
	}

	public Instant getFinishedGame() {
		return finishedGame;
	}

	public void setFinishedGame(Instant finishedGame) {
		this.finishedGame = finishedGame;
	}

	public BoardGame getBoardGame() {
		return boardGame;
	}

	public void setBoardGame(BoardGame boardGame) {
		this.boardGame = boardGame;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	public Player getPlayerOne() {
		return playerOne;
	}
	
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	public Player getPlayerTwo() {
		return playerTwo;
	}

	public MatchStatus getMatchStatus() {
		return MatchStatus.valueOf(matchStatus);
	}

	public void setMatchStatus(MatchStatus matchStatus) {
		if (matchStatus != null) {
			this.matchStatus = matchStatus.getCode();
		}
	}
	public void finishMatch() {
		this.finishedGame = Instant.now();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
