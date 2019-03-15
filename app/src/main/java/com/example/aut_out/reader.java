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

       // String folder;
       // File sdcard = Environment.getExternalStorageDirectory();
       // folder = Environment.getExternalStorageDirectory() + File.separator + "appautismofile" + File.separator + filename;

        File file = new File(path);

      //  File file = new File(sdcard,"contenuto.txt");

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
        //return text.toString();

    }

    private String[] array_constr(String string, String splitter){

        String[] array_letto = string.split(splitter);

        return array_letto;

    }

}
