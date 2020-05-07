package com.example.ht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {
    Button givefb;
    EditText textfb;
    RatingBar ratingfb;
    FeedbackList feedbacks;
    EditText namefb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        namefb = (EditText) findViewById(R.id.fbName);
        textfb = (EditText) findViewById(R.id.fb);
        ratingfb = (RatingBar) findViewById(R.id.ratingBar);
        givefb = (Button) findViewById(R.id.bfeedb);
        givefb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFeedback();
            }
        });
    }
    //Ottaa talteen palautteenantajan ja palautteen sekä lisää palautteen ensimmäisenä olevaan tapahtumaan
    public void addFeedback() {
        feedbacks = EventList.getInstance().getEvent(0).getFeedbackList();
        String feedbackString = textfb.getText().toString();
        String fbName = namefb.getText().toString();
        feedbacks.CreateFeedback(feedbackString, Integer.toString((int) ratingfb.getRating()),fbName);
        finish();
    }

}
