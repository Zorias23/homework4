package com.example.admin.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class DisplayPersonsActivity extends AppCompatActivity {
    ArrayList<Person> persons = new ArrayList<Person>();
    TextView displayPeople;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_persons);
        displayPeople = findViewById(R.id.displayPersons);
       persons =  getIntent().getExtras().getParcelableArrayList("persons");
       displayPersons();
    }

    public void displayPersons()
    {
        String display = "";
        Log.d("DiplayPerons()", "displayPersons: persons.size is: " + persons.size());
        for (Person p: persons)
        {

            display += p.toString() + "\n";
            Log.d("DisplayPersonsActivity", "displayPersons: firstname is:" + p.getFirstName() + " lastname is:" + p.getLastName());
        }
        displayPeople.setText(display);
    }
}
