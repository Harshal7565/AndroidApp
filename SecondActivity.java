package com.epson.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView fn ;
    TextView ln ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fn = findViewById(R.id.fn);
        ln = findViewById(R.id.ln);

        String fn2 = getIntent().getStringExtra("intent1");
        String ln2 = getIntent().getStringExtra("intent2");

        fn.setText(fn2.toString());
        ln.setText(ln2.toString());

    }
}