package com.example.admin.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToCameraActivity(View view)
    {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
    public void goToCalculatorActivity(View view)
    {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
    public void goToPersonActivity(View view)
    {
        Intent intent = new Intent(this, PersonActivity.class);
        startActivity(intent);
    }
}
