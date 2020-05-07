package com.example.ht;

public class Feedback {
    private String feedback;
    private String person;
    private String rating;

    public String getFeedback() {
        return feedback;
    }

    public String getPerson() {
        return person;
    }

    public String getRating() {
        return rating;
    }

    public void setFeedback(String fe) {
        feedback = fe;
    }

    public void setPerson(String pe) {
        person = pe;
    }

    public void setRating(String ra) {
        rating = ra;
    }

    public String toString() {
        return feedback + ", Arvosana " + rating + "/5, käyttäjältä " +person;
    }

}
