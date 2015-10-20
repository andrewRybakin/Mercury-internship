package com.mercury.first.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = "SplashActivity";
    //private final String THREAD_STARTED = "com.mercury.first.splash.SplashActivity.isThreadStarted";
    private boolean isThreadStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (savedInstanceState != null) {
            isThreadStarted = true;
        }
        if (!isThreadStarted) {
            Thread splash = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Log.e(TAG, e.getMessage());
                    }
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
            splash.start();
            isThreadStarted = true;
        }
    }


}
