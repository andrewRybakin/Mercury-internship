package com.mercury.first.splash;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class MainActivity extends FragmentActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(MainActivityFragment.FRAGMENT_TAG);
        if (fragment == null) {
            Log.d(TAG, "Создаем фрагмент");
            fragment = new MainActivityFragment();
            fragmentManager.beginTransaction().replace(R.id.activity_main, fragment, MainActivityFragment.FRAGMENT_TAG)
                    .commit();
        }
    }
}
