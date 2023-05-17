package com.tictactoe.classproject.entities.enums;

public enum PlayerStatus {
	
	ACTIVE(1),
	INACTIVE(2);
	
	private int code;
	private PlayerStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}

	public static PlayerStatus valueOf(int code) {
		for (PlayerStatus value : PlayerStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid player status");
	}
}
