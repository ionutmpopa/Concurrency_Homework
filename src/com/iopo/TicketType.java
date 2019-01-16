package com.iopo;

import java.util.Random;

public enum TicketType {
	A, B, C, D, E;

	public static TicketType getRandom() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}