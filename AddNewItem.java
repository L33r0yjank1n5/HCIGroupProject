package com.example.colton.test;

import android.os.Bundle;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;

public class AddNewItem extends ActionBarActivity {

    EditText nameInput;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        nameInput = (EditText) findViewById(R.id.nameInput);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        Date date = new Date();
        Item item = new Item(nameInput.getText().toString(), date.toString(), date.toString());
        dbHandler.addItem(item);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputText = nameInput.getText().toString();
        dbHandler.deleteItem(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        nameInput.setText("");
    }

}