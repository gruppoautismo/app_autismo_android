package com.example.aut_out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static com.example.aut_out.MainActivity.EXTRA_MESSAGE;

public class trasporti extends AppCompatActivity {

    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasporti);

        /*TextView textView = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();

        indice = intent.getIntExtra(EXTRA_MESSAGE,  -1);

        String[] elenco_prob = getResources().getStringArray(R.array.elenco_problemi);

        textView.setText(elenco_prob[indice]);

        Log.d("sos_____________",Integer.toString(indice));
        Toast.makeText(trasporti.this, Integer.toString(indice ),
                Toast.LENGTH_LONG).show();
        */
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> linuxGroups = new ArrayList<>();
        linuxGroups.add("Ubuntu");
        linuxGroups.add("Kali Linux");
        linuxGroups.add("MacOS");
        item.put("Linux", linuxGroups);
        ArrayList<String> windowsGroups = new ArrayList<>();
        windowsGroups.add("Windows 7");
        windowsGroups.add("Windows 8");
        windowsGroups.add("Windows 10");
        item.put("Windows", windowsGroups);
        MyExpandableAdapter adapter = new MyExpandableAdapter(item);
        expandableListView.setAdapter(adapter);

    }
}
