package com.example.lendrer_hci_groupproject.lendrer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_add);

        final EditText addNameEditText = (EditText) findViewById(R.id.addNameEditText);
        final EditText addStartDayEditText = (EditText) findViewById(R.id.addStartDayEditText);
        final EditText addDueDateEditText = (EditText) findViewById(R.id.addDueDateEditText);
        final EditText addPersonNameEditText = (EditText) findViewById(R.id.addPersonNameEditText);

        new DateInputMask(addStartDayEditText);
        new DateInputMask(addDueDateEditText);

        Button addSaveButton = (Button)findViewById(R.id.addSaveButton);
        addSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addNameEditText.getText().toString();
                String startDate = addStartDayEditText.getText().toString();
                String dueDate = addDueDateEditText.getText().toString();
                String personName = addPersonNameEditText.getText().toString();

                //Add method still needed
                finish();
            }
        });
    }
}
