package com.example.orientalnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Sample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        TextView t=findViewById(R.id.textView);
        String imported=getIntent().getStringExtra("123");
        t.setText("You clicked  "+imported);

    }
}