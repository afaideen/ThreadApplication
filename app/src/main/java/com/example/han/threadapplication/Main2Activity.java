package com.example.han.threadapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.han.threadapplication.model.MyApp;
import com.example.han.threadapplication.model.User;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private MyApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        app = (MyApp) getApplication();
        List<User> users = app.users;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
