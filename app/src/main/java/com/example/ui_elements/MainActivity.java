package com.example.ui_elements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxMarvel, checkBoxDC, checkBoxJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxMarvel = findViewById(R.id.cb_marvel);
        checkBoxDC = findViewById(R.id.cb_dc);
        checkBoxJoker = findViewById(R.id.cb_joker);

        rgMaritalStatus = findViewById(R.id.rg_marital_status);
        int checkedButton = rgMaritalStatus.getCheckedRadioButtonId();

        progressBar = findViewById(R.id.progress_bar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(progressBar.getProgress());
                    if (progressBar.getProgress() >= 90) {
                        progressBar.incrementProgressBy(10);
                        SystemClock.sleep(500);
                        progressBar.setProgress(0);
                        i = 0;
                    }
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();

        //switch for relationship status
        switch (checkedButton) {
            case R.id.rb_married:
                Toast.makeText(MainActivity.this, "You are married", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_single:
                Toast.makeText(MainActivity.this, "You are single", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_in_rel:
                Toast.makeText(MainActivity.this, "You are in a relationship", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_married:
                        Toast.makeText(MainActivity.this, "You are married", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb_single:
                        Toast.makeText(MainActivity.this, "You are single", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb_in_rel:
                        Toast.makeText(MainActivity.this, "You are in a relationship", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
            }
        });

        if (checkBoxMarvel.isChecked()) {
            Toast.makeText(MainActivity.this, "You like Marvel", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You need to watch Marvel movies", Toast.LENGTH_SHORT).show();
        }

        checkBoxMarvel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, "You like Marvel", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "You need to watch Marvel movies", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}