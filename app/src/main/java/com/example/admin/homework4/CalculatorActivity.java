package com.example.admin.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private TextView emiResult;
    private TextView principalResult;
    private TextView interestResult;
    private TextView installmentsResult;
    private SeekBar principal;
    private SeekBar interest;
    private SeekBar installments;
    double progressPrincipal = 10000;
    double progressInterest = 5;
   double progressInstallments = 120;
    private String TAG = "CalculatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initVars();
        //add our listeners to each seekbar
        principal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressPrincipal = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                principalResult.setText(String.valueOf(progressPrincipal));
                calculateEmi(progressPrincipal, progressInterest, progressInstallments);
            }
        });
        interest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressInterest = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                interestResult.setText(String.valueOf(progressInterest));
                calculateEmi(progressPrincipal, progressInterest, progressInstallments);
            }
        });
        installments.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressInstallments = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                installmentsResult.setText(String.valueOf(progressInstallments));
                calculateEmi(progressPrincipal, progressInterest, progressInstallments);
            }
        });
    }
    private void calculateEmi(double p, double r, double n)
    {
        double r_interest = r /1200;
        double emi = 0;
        double numerator = 0;
        double denominator = 0;
        numerator = Math.pow((r_interest+1), n) * p * r_interest;
        denominator = Math.pow((r_interest+1), (n-1));
        Log.d(TAG, "calculateEmi: p:" +  p +  " r:" + r + " n:" + n);
        Log.d(TAG, "calculateEmi: numerator is: " + numerator + " and denominator is " + denominator);
        emi = numerator / denominator;
        emiResult.setText(String.valueOf(emi));
    }
    private void initVars() {
        emiResult = findViewById(R.id.emiResult);
        principalResult = findViewById(R.id.principalResult);
        interestResult = findViewById(R.id.interestResult);
        installmentsResult = findViewById(R.id.installmentsResult);
        principal = findViewById(R.id.principal);
        interest = findViewById(R.id.interest);
        installments = findViewById(R.id.installments);
    }

}
