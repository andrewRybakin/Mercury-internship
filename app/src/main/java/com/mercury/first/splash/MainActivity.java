package com.mercury.first.splash;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.main_activity_fragment);
        if(fragment==null){
            fragment=new MainActivityFragment();
            fragmentManager.beginTransaction().add(R.id.activity_main,fragment)
                    .commit();
        }
    }

}
