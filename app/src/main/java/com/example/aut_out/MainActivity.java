package com.example.aut_out;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button button;
    Spinner spinner;
    int indice = 0;

    String FILE_NAME = "contenuto.txt";

    public static  final String EXTRA_MESSAGE = "com.example.aut_out.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reader rd = new reader();

        String folder = Environment.getExternalStorageDirectory() + File.separator + "appautismofile" + File.separator + "soluzioni.txt";
        String link = getResources().getString(R.string.link);
        Log.d("debug!:", "link:"+link);

        checker check = new checker();




        Log.d("file chk:", "verificando l'esistenza del file");

        boolean file_ex = check.fileExists("soluzioni.txt");

        if(!file_ex) {
           // String link = getResources().getString(R.string.link);
            Log.d("file chk:", "file non esiste");
            Log.d("file down:", "scaricando");
            try{
                new downloader().execute(link);
            }catch (Exception e){
                Log.d("errore:", "errore:"+e.getMessage());
            }
        }
        else{
            Log.d("file chk", "file esiste, continuo");
        }



        //dichiara gli elementi del file xml per quest'attività(MODIFICARE)
        final TextView textView = (TextView) findViewById(R.id.textView);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        button = (Button) findViewById(R.id.button);

        String[] array_ = {"errore"};

        try {
            array_ = rd.leggi(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, array_);

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view

        spinner.setAdapter(spinnerArrayAdapter);



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
