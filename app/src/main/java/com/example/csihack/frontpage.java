package com.example.csihack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class frontpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        Button proceedbtn = (Button) findViewById(R.id.proceedbtn);
        proceedbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                openActivity();
            }
        });
    }
    private void openActivity() {
        android.content.Intent intent = new android.content.Intent(this, MainActivity.class);
        startActivity(intent);
    }
}