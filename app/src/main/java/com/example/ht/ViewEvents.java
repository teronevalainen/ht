package com.example.ht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewEvents extends AppCompatActivity {
    EditText eventName;
    EditText eventStart;
    EditText eventEnd;
    EditText eventPlace;
    EditText eventDate;
    EditText eventAge;
    EditText eventInfo;
    EditText eventVisitors;

    int index;
    Event event;
    Intent intent;

    ListView eventListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);

        intent = getIntent();
        index = intent.getIntExtra("index", 0);

        event = EventList.getInstance().getEvent(index);

        eventName = (EditText) findViewById(R.id.evname);
        eventStart = (EditText) findViewById(R.id.evstart);
        eventEnd = (EditText) findViewById(R.id.evend);
        eventPlace = (EditText) findViewById(R.id.evplace);
        eventDate = (EditText) findViewById(R.id.evdate);
        eventAge = (EditText) findViewById(R.id.evage);
        eventInfo = (EditText) findViewById(R.id.evinfo);
        eventVisitors = (EditText) findViewById(R.id.evvisitors);
        eventListView = (ListView) findViewById(R.id.evfeedback);

        eventName.setText(event.getName());
        eventStart.setText(event.getStart());
        eventEnd.setText(event.getEnd ());
        eventPlace.setText(event.getPlace());
        eventDate.setText(event.getDate());
        eventAge.setText(event.getAge());
        eventInfo.setText(event.getInfo());
        eventVisitors.setText(event.getVisitors());


        ArrayList<Feedback> feedbacks = event.getFeedbackList().getFeedbackList();
        ArrayAdapter<Feedback> adapter_t = new ArrayAdapter<Feedback>(this,
                android.R.layout.simple_expandable_list_item_1, feedbacks);
        adapter_t.setDropDownViewResource(android.R.layout.simple_list_item_1);
        eventListView.setAdapter(adapter_t);
    }

    public void AddNewEvent(View v) {
        event.setName(eventName.getText().toString());
        event.setStart(eventStart.getText().toString());
        event.setEnd(eventEnd.getText().toString());
        event.setPlace(eventPlace.getText().toString());
        event.setDate(eventDate.getText().toString());
        event.setAge(eventAge.getText().toString());
        event.setInfo(eventInfo.getText().toString());
        event.setVisitors(eventVisitors.getText().toString());

        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    public void backToEvenActivity(View v) {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

}
