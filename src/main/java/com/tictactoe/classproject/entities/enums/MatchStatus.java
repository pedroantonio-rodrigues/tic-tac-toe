package com.tictactoe.classproject.entities.enums;

public enum MatchStatus {
	
	STARTED(1),
	FINISHED(2),
	SEARCHING(3);
	
	private int code;
	private MatchStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	
	public static MatchStatus valueOf(int code) {
		for (MatchStatus value : MatchStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid player status");
	}

	
}
