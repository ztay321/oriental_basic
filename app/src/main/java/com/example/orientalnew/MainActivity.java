package com.example.orientalnew;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String KEY="123";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img=findViewById(R.id.imageView);
        Button loginButton = findViewById(R.id.button0);
        Button productsButton = findViewById(R.id.button);
        Button servicesButton = findViewById(R.id.button2);
        Button aboutUsButton = findViewById(R.id.button3);
        Button SignUpButton = findViewById(R.id.button5);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });
        productsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sample.class);
                intent.putExtra(String.valueOf(KEY),"Products");
                startActivity(intent);
                // startActivity(new Intent(MainActivity.this, Sample.class));
            }
        });

        servicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sample.class);
                intent.putExtra(String.valueOf(KEY),"Services");
                startActivity(intent);

            }
        });

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sample.class);
                intent.putExtra(String.valueOf(KEY),"About Us");
                startActivity(intent);
                // startActivity(new Intent(MainActivity.this, Sample.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
}