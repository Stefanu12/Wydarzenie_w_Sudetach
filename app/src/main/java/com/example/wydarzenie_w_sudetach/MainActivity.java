package com.example.wydarzenie_w_sudetach;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int likeCount = 0;
    private String lastRegisteredEmail = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView likeCounter = findViewById(R.id.like_counter);
        TextView message = findViewById(R.id.message);
        EditText emailField = findViewById(R.id.email);
        EditText passwordField1 = findViewById(R.id.password_1);
        EditText passwordField2 = findViewById(R.id.password_2);
        Button likeButton = findViewById(R.id.button_like);
        Button unlikeButton = findViewById(R.id.button_unlike);
        Button submitButton = findViewById(R.id.button1);
        Button showParticipantButton = findViewById(R.id.button2);

        message.setText("Obszar komunikatów");

        likeButton.setOnClickListener(v -> {
            likeCount++;
            likeCounter.setText(likeCount + " polubień");
        });

        unlikeButton.setOnClickListener(v -> {
            if (likeCount > 0) {
                likeCount--;
                likeCounter.setText(likeCount + " polubień");
            }
        });

        submitButton.setOnClickListener(v -> {
            String email = emailField.getText().toString().trim();
            String password1 = passwordField1.getText().toString().trim();
            String password2 = passwordField2.getText().toString().trim();

            if (!email.contains("@")) {
                message.setText("Nieprawidłowy adres e-mail");
            } else if (!password1.equals(password2)) {
                message.setText("Hasła się różnią");
            } else {
                message.setText("Zarejestrowano: " + email);
                lastRegisteredEmail = email;
            }
        });

        showParticipantButton.setOnClickListener(v -> {
            if (lastRegisteredEmail != null) {
                message.setText("Zarejestrowany uczestnik: " + lastRegisteredEmail);
            } else {
                message.setText("Brak zarejestrowanego uczestnika");
            }
        });
    }
}