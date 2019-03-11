package com.example.aut_out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    Spinner spinner;
    int indice = 0;

    public static  final String EXTRA_MESSAGE = "com.example.aut_out.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dichiara gli elementi del file xml per quest'attività(MODIFICARE)
        final TextView textView = (TextView) findViewById(R.id.textView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button);

        //quando un elemento del menu viene selezionato aggiorna la variabile indice
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indice = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                indice = -1;
            }
        });

    }
    //avvia la seconda attivita(trasporti) e porta l'indice come messaggio
    public  void apri_att(View view){


        Intent intent = new Intent(this, trasporti.class);
        intent.putExtra(EXTRA_MESSAGE, indice);

        startActivity(intent);
    }

}
