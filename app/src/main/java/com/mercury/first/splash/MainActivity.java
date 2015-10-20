package com.mercury.first.splash;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    private final String FRAGMENT_ADDED="com.mercury.first.splash.MainActivity.isFragmentAdded";
    private boolean isFragmentAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            isFragmentAdded=savedInstanceState.getBoolean(FRAGMENT_ADDED,false);
        }
        if(!isFragmentAdded){
            FragmentManager fragmentManager=getFragmentManager();
            Fragment fragment=fragmentManager.findFragmentById(R.id.main_activity_fragment);
            /**
             Очень странно, но если мне не изменяет память, то поиск фрагмента по id должен вернуть фрагмент если он уже существует...
             Но почему то каждый раз при повороте добавляет новый фрагмент и в итоге получается фрагмент на фрагменте фрагмент погоняет...
             Я к сожалению в непонятках почему это так, но когда в глубоком детстве делал по одной книжечке (Брайана Харди и Билла Филлипса),
             то оно работало прекрасно. Может у меня просто телефон баганутый... Или я баганутый...
             Пришлось делать костыли :( Это странно, ведь фрагмент вроде как создан чтобы избавиться от сохранения в бандл...
             */
            if(fragment==null){
                fragment=new MainActivityFragment();
                fragmentManager.beginTransaction().add(R.id.activity_main,fragment)
                        .commit();
                isFragmentAdded=true;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(FRAGMENT_ADDED,isFragmentAdded);
    }
}
