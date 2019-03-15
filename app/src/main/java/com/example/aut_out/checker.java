package com.example.aut_out;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class checker {

    public boolean check_file(String file_name){

        Log.d("cheker", "CHIAMATO BOIS");
        String file = android.os.Environment.getExternalStorageDirectory().getPath() + file_name;
        File f = new File(file);

        if(f.exists()) {
            return true;
        }

        return false;
    }

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
