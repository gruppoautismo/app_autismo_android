package android.example.com.download_3;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class downloader extends AsyncTask<String, String, String> {



        private ProgressDialog progressDialog;
        private String fileName;
        private String folder;
        private boolean isDownloaded;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();

                int lengthOfFile = connection.getContentLength();



                InputStream input = new BufferedInputStream(url.openStream(), 8192);


                fileName = f_url[0].substring(f_url[0].lastIndexOf('/') + 1, f_url[0].length());


                //External directory path to save file
                folder = Environment.getExternalStorageDirectory() + File.separator + "appautismofile/";


                File directory = new File(folder);

                if (!directory.exists()) {
                    directory.mkdirs();
                }


                OutputStream output = new FileOutputStream(folder + fileName);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;

                    publishProgress("" + (int) ((total * 100) / lengthOfFile));

                    output.write(data, 0, count);
                }


                output.flush();


                output.close();
                input.close();
                return "Downloaded at: " + folder + fileName;

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "Something went wrong";
        }


        protected void onProgressUpdate(String... progress) {

           // progressDialog.setProgress(Integer.parseInt(progress[0]));
        }


        @Override
        protected void onPostExecute(String message) {

            Log.d("post", "eseguito bois");

        }

}
