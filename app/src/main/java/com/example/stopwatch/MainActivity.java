package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1,b2,b3;
    int seconds=0;
    private boolean running;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        b1=findViewById(R.id.b_start);
        b2=findViewById(R.id.b_pause);
        b3=findViewById(R.id.b_reset);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime();
                running=true;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               running=false;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
                seconds=0;
            }
        });
    }

    private void startTime()
    {
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minute=(seconds%3600)/60;
                int sec=seconds%60;
                String time=String.format("%02d:%02d:%02d",hours,minute,sec);
                t1.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,0);
            }
        });
    }
}