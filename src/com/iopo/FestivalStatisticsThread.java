package com.iopo;

import java.util.Collections;
import java.util.Queue;

public class FestivalStatisticsThread extends Thread {

	private FestivalGate gate;

	public FestivalStatisticsThread(FestivalGate gate) {
		this.gate = gate;
	}

	@Override
	public void run() {
		System.out.println("Generating report ...");
		try {
			while (true) {
				Thread.sleep(5000);
				showStatistics();
			}
			
		} catch (InterruptedException e) {
		}
	}

	public void showStatistics() {
		synchronized (this) {
			Queue<String> ticketsShown = gate.getTicketShown();
			if (ticketsShown.size() == 0) {
				System.out.println("Your queue is empty!");
			} else {
				System.out.println("\n" + ticketsShown.size() + " people entered");
				System.out.println(Collections.frequency(ticketsShown, "A") + " people have full tickets.\n"
						+ Collections.frequency(ticketsShown, "B") + " people have free passes.\n"
						+ Collections.frequency(ticketsShown, "C") + " people have one-day passes.\n"
						+ Collections.frequency(ticketsShown, "D") + " people have one-day Vip passes.\n"
						+ Collections.frequency(ticketsShown, "E") + " people have full Vip passes.");

			}
		}
	}
}