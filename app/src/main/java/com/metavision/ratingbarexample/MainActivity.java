package com.metavision.ratingbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button submitRateButton;
    TextView rateDisplay;
    EditText commentArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        submitRateButton = (Button) findViewById(R.id.ratingSubmitButton);
        rateDisplay = (TextView) findViewById(R.id.ratingDisplay);
        rateDisplay.setText("Rate: ");
        commentArea = (EditText) findViewById(R.id.commentArea);

        commentArea.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return  false;
            }
        });
    }

    public void rateSubmit(View view) {
        String ratingValue = String.valueOf(ratingBar.getRating());
        if (ratingValue.equals("0.0"))
            Toast.makeText(getApplicationContext(), "Rating tidak boleh Nol", Toast.LENGTH_LONG).show();
        rateDisplay.setText("Rate: " + ratingValue);
        Toast.makeText(getApplicationContext(), "Rate: " + ratingValue, Toast.LENGTH_LONG).show();
    }
}
