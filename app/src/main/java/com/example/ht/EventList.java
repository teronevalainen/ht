package com.example.ht;

import java.util.ArrayList;

public class EventList {
    private EventList() {
        Event event1 = new Event("Aamukerho", "Avis", "07/04", "8:00",
                "11:00", "9-13", "Pleikkarin peluu", "33");
        Event event2 = new Event("Iltapäiväkerho", "Avis", "07/04", "13:00",
                "16:00", "14-17", "Lautapelit", "44");
        Event event3 = new Event("Iltakerho", "Avis", "07/04", "17",
                "19:30", "13-16", "Kivaa hauskaa", "23");
        events.add(event1);
        events.add(event2);
        events.add(event3);
    }
    private static EventList instance = new EventList();
    private ArrayList<Event> events = new ArrayList<Event>();

    public static EventList getInstance() {
        return instance;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void CreateEvent(String name, String place, String date, String start,
                            String end,  String age, String info, String visitors )
    {
        Event newEvent = new Event(name, place, date, start, end, age, info, visitors);
        events.add(newEvent);
    }
    // Siirtää tapahtuman listan kärkeen kun aloitetaan tapahtuma
    public void setIndex(int index) {
        Event ev = events.get(index);
        events.set(events.indexOf(ev), events.get(0));
        events.set(0,ev);
    }

    public Event getEvent(int i) {
        return events.get(i);
    }

    public void removeEvent(int index) {
        events.remove(index);
    }

}
