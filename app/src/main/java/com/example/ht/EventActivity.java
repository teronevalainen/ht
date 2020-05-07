package com.example.ht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    ListView listView;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        listView = (ListView) findViewById(R.id.listViewEvent);

        ArrayList<Event> events = EventList.getInstance().getEvents();
        ArrayAdapter<Event> adapt = new ArrayAdapter<Event>(this,
                android.R.layout.simple_spinner_item, events);
        adapt.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listView.setAdapter(adapt);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;       //Päivittää indexiä sen mukaan kun klikataan itemiä
            }
        });
    }
    // päivittää listaa
    public void update() {
        ((ArrayAdapter) listView.getAdapter()).notifyDataSetChanged();
    }

    public void startEvent(View v) {
        EventList.getInstance().setIndex(index);
        update();
    }

    public void addNewEvent(View v) {
        EventList.getInstance().CreateEvent("Uusi tapahtuma", "", "",
                "", "", "", "", "");
        update();
    }

    public void deleteEvent(View v) {
        EventList.getInstance().removeEvent(index);
        update();
    }

    public void EventViewLauncher(View v) {
        Intent intent = new Intent(this, ViewEvents.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    public void backtoMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
