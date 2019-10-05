package com.adonis.practicalexam2_adonis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8;
    EditText comments;
    FileOutputStream writer;
    FileOutputStream writer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbox1 = findViewById(R.id.checkBox);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);
        checkbox5 = findViewById(R.id.checkBox5);
        checkbox6 = findViewById(R.id.checkBox6);
        checkbox7 = findViewById(R.id.checkBox7);
        checkbox8 = findViewById(R.id.checkBox8);
        comments = findViewById(R.id.editText);


    }

    public void NextPage (View v) {
        Intent i = new Intent (this, SecondPage.class);
        startActivity(i);
    }

    public void writeData (View v) {
        String data1 = checkbox1.getText().toString();
        String data2 = checkbox2.getText().toString();
        String data3 = checkbox3.getText().toString();
        String data4 = checkbox4.getText().toString();
        String data5 = checkbox5.getText().toString();
        String data6 = checkbox6.getText().toString();
        String data7 = checkbox7.getText().toString();
        String data8 = checkbox8.getText().toString();
        String datacomments = comments.getText().toString();
        String alldata = " ";

        if (checkbox1.isChecked()) {
            alldata += (data1 + ", ");
        }

        if (checkbox2.isChecked()) {
            alldata += (data2 + ", ");
        }

        if (checkbox3.isChecked()) {
            alldata += (data3 + ", ");
        }

        if (checkbox4.isChecked()) {
            alldata += (data4 + ", ");
        }

        if (checkbox5.isChecked()) {
            alldata += (data5 + ", ");
        }

        if (checkbox6.isChecked()) {
            alldata += (data6 + ", ");
        }

        if (checkbox7.isChecked()) {
            alldata += (data7 + ", ");
        }

        if (checkbox8.isChecked()) {
            alldata += (data8 + ", ");
        }

        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            /*if (checkbox1.isChecked()) {
                writer.write((checkbox1.getText().toString() + ", ").getBytes());
            }*/

            writer.write(alldata.getBytes());

            writer2 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer2.write((" " + datacomments).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO Error");
        } finally {
            try {
                writer.close();
                writer2.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("error", "File Not Found");
            }
        }

        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
    }
}
