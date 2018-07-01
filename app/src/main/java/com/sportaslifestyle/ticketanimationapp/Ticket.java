package com.sportaslifestyle.ticketanimationapp;

public class Ticket {

    private String price;
    private String time;
    private String from;
    private String to;
    private int requests;

    public Ticket(String price, String time, String from, String to, int requests) {
        this.price = price;
        this.time = time;
        this.from = from;
        this.to = to;
        this.requests = requests;
    }

    public String getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getRequests() {
        return requests;
    }
}
