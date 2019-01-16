package com.iopo;

public class FestivalAttendeeThread extends Thread {

	private FestivalGate gate;
	private TicketType ticketType;

	public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
		this.ticketType = ticketType;
		this.gate = gate;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			gate.addTicket(ticketType);
		} catch (InterruptedException e) {
		}
	}

	public FestivalGate getGate() {
		return gate;
	}

	public TicketType getTicketType() {
		return ticketType;
	}
}