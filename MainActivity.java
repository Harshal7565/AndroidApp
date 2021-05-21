package com.epson.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button next ;
    EditText first ;
    EditText last ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.profile);
        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               Intent i = new Intent(MainActivity.this , SecondActivity.class);
               i.putExtra("intent1",first.getText().toString());
               i.putExtra("intent2",last.getText().toString());
               startActivity(i);
            }
        });

        final Calendar myCalendar = Calendar.getInstance();

        EditText edittext= (EditText) findViewById(R.id.date);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                edittext.setText(sdf.format(myCalendar.getTime()));
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        Spinner dropdown = findViewById(R.id.spinner);

        String[] items = new String[]{"Gender", "Male", "Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);


        Spinner dropdown2 = findViewById(R.id.spinner1);

        String[] items2 = new String[]{"Blood Group","A+", "B+", "AB+","O+","A-","B-","AB-","O-"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        dropdown2.setAdapter(adapter2);



    }



}