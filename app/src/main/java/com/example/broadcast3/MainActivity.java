package com.example.broadcast3;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //makeReceiver(); //for android 8+ only mentioning intent filter in Manifest wont work
        Toast.makeText(this, "All Ready....", Toast.LENGTH_SHORT).show();
        Log.e("OnCreate","all ready....");
    }

    private void makeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.addAction("android.intent.action.AIRPLANE_MODE_CHANGED");

        receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, filter);

    }
}
