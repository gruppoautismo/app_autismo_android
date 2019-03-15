package com.example.aut_out;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class reader {

    String letto;

    public String[] leggi(String path) throws IOException {

        File file = new File(path);

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            Log.d("reader:","ERRORE NELLA LETTURA DEL FILE");
        }

        String[] array_ = array_constr(text.toString(), ",");

        return array_;


    }

    private String[] array_constr(String string, String splitter){

        String[] array_letto = string.split(splitter);

        for(int x = 0; x < array_letto.length; x++){
            array_letto[x] = array_letto[x].replace('"', ' ');

        }

        return array_letto;

    }

}
