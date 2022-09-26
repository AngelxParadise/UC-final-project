package com.example.foodtrucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Context c;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textname = findViewById(R.id.editTextName);
        EditText textemail = findViewById(R.id.editTextEmail);

        Button next = findViewById(R.id.buttonnext);
        c = this;

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = textname.getText().toString();
                String b = textemail.getText().toString();

                if (a.equals("") && b.equals("")) {
                    Toast.makeText(c, "Please enter the missing information", Toast.LENGTH_LONG).show();
                } else if (a.equals("")) {
                    Toast.makeText(c, "Please enter your name", Toast.LENGTH_LONG).show();
                } else if (b.equals("")) {
                    Toast.makeText(c, "Please enter your email", Toast.LENGTH_LONG).show();
                } else if (!b.endsWith("@gmail.com") && !b.endsWith("@hotmail.com") && !b.endsWith("@yahoo.com") && !b.endsWith("@outlook.com") && !b.endsWith("@live.com")) {
                    Toast.makeText(c, "Please enter a valid email", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", a);
                    intent.putExtra("email", b);

                    startActivity(intent);
                }
            }
        });
    }
}