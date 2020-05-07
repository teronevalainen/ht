package com.example.ht;

import java.util.ArrayList;

public class FeedbackList {
    private ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();

    public void CreateFeedback(String feedback, String rating, String person) {
        Feedback newfb = new Feedback();
        newfb.setFeedback(feedback);
        newfb.setRating(rating);
        newfb.setPerson(person);
        feedbacks.add(newfb);
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbacks;
    }
}
