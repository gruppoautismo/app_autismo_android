package com.example.aut_out;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);


        Spinner spinner = (Spinner) findViewById(R.id.spinner_);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // textView.setText(position);
                textView.setText(Integer.toString(position));

                if(position == 1){
                    //cambia vista
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //textView.setText("");
            }
        });




    }
}
