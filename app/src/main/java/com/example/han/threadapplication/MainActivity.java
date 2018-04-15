package com.example.han.threadapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.han.threadapplication.model.MyApp;
import com.example.han.threadapplication.model.User;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private long time;
    private static final String TAG = "mytagMainActivity";
    private Timer timer;
    private TextView tv1, tv2;
    private TimerTask task;
    private MyApp app;
    private User user1, user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textview);
        tv2 = findViewById(R.id.textview2);
        mStartTimer();

        user1 = new User("han", 801129);
        user2 = new User("aizul", 105845);
        app = (MyApp) getApplication();
        app.users.add(user1);
        app.users.add(user2);
    }

    private void mStartTimer() {
        Log.d(TAG, "mStartTimer: ");
        task = getTask();
        timer = new Timer(true);
        timer.schedule(task, 1000, 1000);
    }

    @NonNull
    private TimerTask getTask() {

        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                time = System.currentTimeMillis();
                Log.d(TAG, "run: " + time);

                tv1.post(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText("" + time);
                    }
                });
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv2.setText("" + time);
                    }
                });

            }
        };
        return t;
    }



    public void OnClickBtn(View view) {
        switch (view.getId()){
            case R.id.buttonClick:
                if(timer != null) {
                    if(task != null) {
                        timer.cancel();
                        task = null;
                    }
                    else{
                        mStartTimer();
                    }

                }
                break;
            case R.id.buttonPage2:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
        }

    }
}
