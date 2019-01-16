package com.iopo;

import java.util.Random;

public class Main {
	private static Random random = new Random();

	public static void main(String[] args) {
		try {
			FestivalGate gate = new FestivalGate();
			FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
			int result = getRandomNumberInRange(random.nextInt(50000));
			statsThread.start();
			startAttendees(gate, result);
		} catch (InterruptedException e) {
			System.err.println("Trouble at the gate: " + e.getLocalizedMessage());
		}
	}

	private static void startAttendees(FestivalGate gate, int minimumThreads) throws InterruptedException {
		int counter = 0;
		while (counter <= minimumThreads) {
			int result = getRandomNumberInRange(random.nextInt(1000));
			for (int i = 1; i < result; i++) {
				FestivalAttendeeThread attendee = new FestivalAttendeeThread(TicketType.getRandom(), gate);
				attendee.start();
				counter++;
			}
			// sleep to simulate attendees' flow
			Thread.sleep(5000);
		}
	}

	private static int getRandomNumberInRange(int number) {
		if (number < 100) {
			return 100;
		} else {
			return random.nextInt(number);
		}
	}
}