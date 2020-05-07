package com.example.ht;

public class Event {
    private String name;
    private String place;
    private String date;
    private String start;
    private String end;
    private String info;
    private String age;
    private String visitors;

    public String toString() {
        return name;
    }

    public Event( String name, String place, String date, String start,
                  String end, String age, String info, String visitors )
    {
            this.name = name;
            this.place = place;
            this.date = date;
            this.start = start;
            this.end = end;
            this.age = age;
            this.info = info;
            this.visitors = visitors;
    }

   public String getName() {
        return name;
    }
    public String getPlace() {
        return place;
    }
    public String getDate() {
        return date;
    }
    public String getStart() {
        return start ;
    }
    public String getEnd() {
        return end;
    }
    public String getAge() {
        return age;
    }
    public String getInfo() {
        return info;
    }
    public String getVisitors() {
        return visitors;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setVisitors(String visitors) {
        this.visitors = visitors;
    }

    private FeedbackList feedbackList = new FeedbackList();
    public FeedbackList getFeedbackList () {
        return feedbackList;
    }

}
