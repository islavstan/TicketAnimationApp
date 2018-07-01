package com.sportaslifestyle.ticketanimationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TicketAdapter adapter = new TicketAdapter(createList(), this);
        RecyclerView recyclerView = findViewById(R.id.rvTickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<Ticket> createList() {
        List<Ticket> list = new ArrayList<>();
        list.add(new Ticket("30$", "12:00", "Dnipro", "Kiev", 10));
        list.add(new Ticket("40$", "16:00", "Dnipro", "Kiev", 3));
        list.add(new Ticket("80$", "14:00", "Dnipro", "Kiev", 22));
        list.add(new Ticket("10$", "13:00", "Dnipro", "Kiev", 1));
        list.add(new Ticket("30$", "11:00", "Dnipro", "Kiev", 56));
        list.add(new Ticket("20$", "12:00", "Dnipro", "Kiev", 78));
        list.add(new Ticket("90$", "10:00", "Dnipro", "Kiev", 11));
        return list;
    }
}

