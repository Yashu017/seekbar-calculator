package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button calc;
    private TextView percentage;
    private TextView result;
    private SeekBar percbar;
    private EditText amount;
    private int seekbarpercentage;
    private float bill;
    private TextView tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = (EditText) findViewById(R.id.billamtID);
        calc = (Button) findViewById(R.id.calcID);
        result = (TextView) findViewById(R.id.resultID);
        percentage = (TextView) findViewById(R.id.percID);
        percbar = (SeekBar) findViewById(R.id.seekBar3);
        tax=(TextView) findViewById(R.id.tax_id);
        calc.setOnClickListener(this);
        percbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentage.setText(String.valueOf(seekBar.getProgress()) + "%");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarpercentage = seekBar.getProgress();


            }
        });
    }

    @Override
    public void onClick(View view) {
        calculate();

    }

    public void calculate() {
        float resultnet = 0.0f;
        float taxbill=0.0f;


        bill = Float.parseFloat(amount.getText().toString());
        resultnet =bill+ bill * seekbarpercentage / 100;
        taxbill=bill*5/100;
        tax.setText("your bill inclusive of cst and gst is"+ String.valueOf(taxbill));
        result.setText("your total bill is" + String.valueOf(resultnet));

    }
}