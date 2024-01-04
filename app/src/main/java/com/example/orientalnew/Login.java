package com.example.orientalnew;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText usernameEditText;
        EditText passwordEditText;
        Button loginButton;
        FirebaseAuth auth = FirebaseAuth.getInstance();


        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (!username.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                    if (!password.isEmpty()) {
                        auth.signInWithEmailAndPassword(username, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Login unsuccessful", Toast.LENGTH_SHORT).show();

                            }
                        });

                    } else {
                        Toast.makeText(Login.this, "Password empty", Toast.LENGTH_SHORT).show();
                    }


                } else if (username.isEmpty()) {
                    Toast.makeText(Login.this, "Email empty", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(Login.this, "Email and password dont match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
