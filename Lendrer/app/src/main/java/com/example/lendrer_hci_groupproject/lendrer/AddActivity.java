package com.example.lendrer_hci_groupproject.lendrer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    MyDBHandler dbHandler;

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

        dbHandler = new MyDBHandler(this, null, null, 1);

        Button addSaveButton = (Button)findViewById(R.id.addSaveButton);
        addSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addNameEditText.getText().toString();
                String startDate = addStartDayEditText.getText().toString();
                String dueDate = addDueDateEditText.getText().toString();
                String personName = addPersonNameEditText.getText().toString();

                //Add method still needed
                Item item = new Item(name, startDate, dueDate, personName);
                dbHandler.addItem(item);
                finish();
            }
        });
    }


}
