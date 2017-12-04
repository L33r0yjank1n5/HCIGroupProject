package com.example.lendrer_hci_groupproject.lendrer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView itemList;
    String[] names;
    String[] startDates;
    String[] dueDates;
    String[] personNames;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void onResume() {
        super.onResume();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new MyDBHandler(this, null, null, 1);

        Resources res = getResources();
        itemList = findViewById(R.id.itemList);
        //Get values from database
        names = dbHandler.databaseToArray();
        startDates = dbHandler.databaseDateArray();
        dueDates = dbHandler.databaseDueDateArray();
        personNames = dbHandler.databaseLentToArray();

        ItemAdapter itemAdapter = new ItemAdapter(this, names, startDates, dueDates, personNames);
        itemList.setAdapter(itemAdapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent showEditActivity = new Intent(getApplicationContext(), EditActivity.class);
                String s = names[position] + "," + startDates[position] + "," + dueDates[position] + "," + personNames[position];
                showEditActivity.putExtra("itemSelected", s);
                startActivity(showEditActivity);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showAddActivity = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(showAddActivity);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
