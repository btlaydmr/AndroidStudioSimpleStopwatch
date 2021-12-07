package com.nuraydemir.timerodev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.nuraydemir.timerodev.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Runnable runnable1;
    Handler handler1;
    Runnable runnable2;
    Handler handler2;
    Runnable runnable3;
    Handler handler3;
    int hour;
    int minute;
    int second;
    int tiklanma=1;
    boolean onClickStop=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        second = 0;
        minute = 0;
        hour = 0;

     binding.button2.setEnabled(false);
        binding.button2.setVisibility(View.INVISIBLE);
    }

    public void start(View view) {
        binding.button2.setVisibility(View.VISIBLE);
        binding.button2.setEnabled(true);
        handler1=new Handler();
        runnable1=new Runnable() {
            @Override
            public void run() {
                second++;
                if(second==60)
                {
                    second = 0;
                    minute++;

                }
                if (minute == 60)
                {
                    minute= 0;
                    second = 0;
                    hour++;
                }
                binding.textView.setText(hour+": "+minute+": "+second);
                handler1.postDelayed(runnable1,1000);
            }
        };
        handler1.post(runnable1);
        binding.button.setEnabled(false);


        }
        public void stop(View view) {

            if (view.isSelected()==false) {
                binding.button2.setText("RESUME");
                view.setSelected(true);
                handler1.removeCallbacks(runnable1);
            } else {
                binding.button2.setText("STOP");
                view.setSelected(false);
                handler1.postDelayed(runnable1, 1000);
                runnable2 = new Runnable() {
                    @Override
                    public void run() {
                        second++;
                        if (second == 60) {
                            second = 0;
                            minute++;

                        }
                        if (minute == 60) {
                            minute = 0;
                            second = 0;
                            hour++;
                        }
                        binding.textView.setText(hour + ": " + minute + ": " + second);
                        handler1.postDelayed(runnable1, 1000);
                    }

                };

            }

        }

    public void restart(View view){
        binding.button2.setVisibility(View.INVISIBLE);
        binding.button2.setEnabled(false);
        onClickStop=true;
        binding.button.setEnabled(true);
        binding.button3.setEnabled(true);
        handler1.removeCallbacks(runnable1);
        second=0;
        binding.textView.setText("0: 0: "+second);


    }


    }
