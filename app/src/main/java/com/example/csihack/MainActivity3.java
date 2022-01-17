package com.example.csihack;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView progressText;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        int numbertwo =intent.getIntExtra(MainActivity2.EXTRA_NUMBERTWO,0);
        int number =intent.getIntExtra(MainActivity2.EXTRA_NUMBER,0);

        android.widget.TextView textView1 = (android.widget.TextView) findViewById(R.id.textview1);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(R.id.textview2);

        textView1.setText("Remaining Sessions: "+numbertwo);
//        textView2.setText("opone "+ number);



        // set the id for the progressbar and progress text
        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);

        final android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // set the limitations for the numeric
                // text under the progress bar
                if (i <= number) {
                    progressText.setText("" + i+"%");
                    progressBar.setProgress(i);
                    i++;
                    handler.postDelayed(this, 0);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, 50);
    }
}

