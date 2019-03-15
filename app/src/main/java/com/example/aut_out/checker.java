package com.example.aut_out;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class checker {


    public boolean fileExists( String filename) {

        String folder;

        folder = Environment.getExternalStorageDirectory() + File.separator + "appautismofile" + File.separator + filename;

        File directory = new File(folder);

        if(directory.exists()){
            return true;
        }

        Log.d("checker_db","path:"+folder);

        return false;
    }

}
