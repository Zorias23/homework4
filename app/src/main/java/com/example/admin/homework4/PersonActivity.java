package com.example.admin.homework4;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {
    private ArrayList<Person> persons = new ArrayList<Person>();
    EditText fname;
    EditText lname;
    private String TAG = "PersonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        fname = findViewById(R.id.etFirstName);
        lname = findViewById(R.id.etLastName);
    }
    public void savePerson(View view)
    {
        Person p = new Person();
        p.setFirstName(fname.getText().toString());
        p.setLastName(lname.getText().toString());
        Log.d(TAG, "savePerson: fname:" + fname.getText().toString() + " lname: " + lname.getText().toString());
        persons.add(p);
    }
    public void displayPersons(View view)
    {
        Intent intent = new Intent(this, DisplayPersonsActivity.class);
        Log.d(TAG, "displayPersons: persons.size is: " + persons.size());
        String display = "";
        for (Person p: persons)
        {

            display += p.toString() + "\n";
            Log.d("PersonActivity", "displayPersons: firstname is:" + p.getFirstName() + " lastname is:" + p.getLastName());
        }
        intent.putParcelableArrayListExtra("persons", persons);
        startActivity(intent);
    }
}
