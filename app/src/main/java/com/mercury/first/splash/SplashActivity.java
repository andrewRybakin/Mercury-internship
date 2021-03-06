package com.mercury.first.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = "SplashActivity";
    private final String THREAD_STARTED = "com.mercury.first.splash.SplashActivity.isThreadStarted";
    private boolean isThreadStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (savedInstanceState != null) {
            isThreadStarted = savedInstanceState.getBoolean(THREAD_STARTED, false);
            Log.d(TAG, "Выпихнули: " + isThreadStarted);
        }
        if (!isThreadStarted) {
            Thread splash = new Thread(new Runnable() {
                @Override
                public void run() {
                    isThreadStarted = true;
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Log.e(TAG, e.getMessage());
                    }
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
            Log.d(TAG, "Запускаем");
            splash.start();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(THREAD_STARTED, isThreadStarted);
        Log.d(TAG, "Запихнули: " + isThreadStarted);
    }


}
