package com.example.lendrer_hci_groupproject.lendrer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm action")
                .setMessage("There may be unsaved changes, are you sure you want to go back?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent in = getIntent();
        String input = in.getStringExtra("itemSelected");
        String[] inputs = input.split("[,]");
        final EditText editNameEditText = (EditText) findViewById(R.id.editNameEditText);
        final EditText editStartDayEditText = (EditText) findViewById(R.id.editStartDayEditText);
        final EditText editDueDateEditText = (EditText) findViewById(R.id.editDueDateEditText);
        final EditText editPersonNameEditText = (EditText) findViewById(R.id.editPersonNameEditText);

        new DateInputMask(editStartDayEditText);
        new DateInputMask(editDueDateEditText);
        editNameEditText.setText(inputs[0]);
        editStartDayEditText.setText(inputs[1]);
        editDueDateEditText.setText(inputs[2]);
        editPersonNameEditText.setText(inputs[3]);

        Button editSaveButton = (Button) findViewById(R.id.editSaveButton);
        editSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] saved = new String[4];
                saved[0] = editNameEditText.getText().toString();
                saved[1] = editStartDayEditText.getText().toString();
                saved[2] = editDueDateEditText.getText().toString();
                saved[3] = editPersonNameEditText.getText().toString();

                String test = saved.toString();
                //Method to save changes here
                finish();
            }
        });

        Button editDeleteButton = (Button) findViewById(R.id.editDeleteButton);
        editDeleteButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
                builder.setTitle("Confirm Action")
                        .setMessage("You are about to delete this entry, do you wish to continue?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //delete from file
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        }));


    }
}
