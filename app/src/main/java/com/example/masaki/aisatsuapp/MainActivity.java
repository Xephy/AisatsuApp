package com.example.masaki.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAisatsu();
            }
        });
    }

    private void setAisatsu() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            mTextView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay < 18) {
                            mTextView.setText("こんにちは");
                        } else if (hourOfDay >= 18 && hourOfDay < 24 || hourOfDay >= 0 && hourOfDay < 2) {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                0,
                0,
                true
        );
        timePickerDialog.show();
    }

}
