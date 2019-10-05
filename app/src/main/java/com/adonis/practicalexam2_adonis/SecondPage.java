package com.adonis.practicalexam2_adonis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondPage extends AppCompatActivity {
    String data, data2;
    EditText allactivities, allcomments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        FileInputStream reader;
        FileInputStream reader2;

        allactivities = findViewById(R.id.editText2);
        allcomments = findViewById(R.id.editText3);

        try {
            reader = openFileInput("data1.txt");
            reader2 = openFileInput("data2.txt");
            int token;
            while ((token = reader.read()) != -1) {
                data = data + (char)token;
            }
            while ((token = reader2.read()) != -1) {
                data2 = data2 + (char)token;
            }

            allactivities.setText(data);
            allcomments.setText(data2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO Error");
        }
    }

    public void PrevPage (View v) {
        Intent i = new Intent (this, MainActivity.class);
        startActivity(i);
    }

    public void Confirm (View v) {
        Toast.makeText(this, "Registration Sent", Toast.LENGTH_LONG).show();
    }
}
