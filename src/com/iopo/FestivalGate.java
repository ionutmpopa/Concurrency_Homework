package com.iopo;


import java.util.ArrayDeque;
import java.util.Queue;

public class FestivalGate {

    private Queue<String> ticketShown;

    public FestivalGate() {
        this.ticketShown = new ArrayDeque<>();
    }

    public synchronized void addTicket(TicketType ticketType) {
    	ticketShown.add(ticketType.toString());
    }

    public synchronized Queue<String> getTicketShown() {
        return ticketShown;
    }
}