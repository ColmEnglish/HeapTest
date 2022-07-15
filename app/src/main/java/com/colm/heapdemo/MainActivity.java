package com.colm.heapdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MAIN_ACTIVITY";

    private SwitchCompat test_switch_1;
    private SwitchCompat test_switch_2;
    private RadioGroup radioGroup1;

    private AppCompatRadioButton radio_1;
    private AppCompatRadioButton radio_2;
    private AppCompatRadioButton radio_3;

    private CheckBox checkbox1;
    private CheckBox checkbox2;



    private void findViews() {
        test_switch_1 = (SwitchCompat) findViewById(R.id.test_switch_1);
        test_switch_2 = (SwitchCompat) findViewById(R.id.test_switch_2);

        test_switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Log.i(TAG, "switch 1 ON");
                }else{
                    Log.i(TAG, "switch 1 OFF");
                }
            }
        });

        test_switch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Log.i(TAG, "switch 2 ON");
                }else{
                    Log.i(TAG, "switch 2 OFF");
                }
            }
        });

        radioGroup1 = (RadioGroup) findViewById(R.id.radio_group_1);

        radio_1 = (AppCompatRadioButton) findViewById(R.id.radio_1);
        radio_2 = (AppCompatRadioButton) findViewById(R.id.radio_2);
        radio_3 = (AppCompatRadioButton) findViewById(R.id.radio_3);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.i(TAG, "selected "+i);
            }
        });
        radio_1.setOnClickListener( this );
        radio_2.setOnClickListener( this );
        radio_3.setOnClickListener( this );

        checkbox1 = (CheckBox) findViewById(R.id.checkbox_1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox_2);

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Log.i(TAG, "checkbox 1 ON");
                }else{
                    Log.i(TAG, "checkbox 1 OFF");
                }
            }
        });

        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Log.i(TAG, "checkbox 2 ON");
                }else{
                    Log.i(TAG, "checkbox 2 OFF");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if ( v == radio_1 ) {
            Log.i(TAG, "onClick: radio_1");
        } else if ( v == radio_2 ) {
            Log.i(TAG, "onClick: radio_2");
        } else if ( v == radio_3 ) {
            Log.i(TAG, "onClick: radio_3");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        startTimer();
    }

    private void startTimer() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(radio_3.isChecked()) {
                    radio_2.setChecked(true);
                    test_switch_1.setChecked(false);
                    checkbox1.setChecked(false);
                }else{
                    radio_3.setChecked(true);
                    test_switch_1.setChecked(true);
                    checkbox1.setChecked(true);
                }
                startTimer();
            }
        }, 5000);

    }


}