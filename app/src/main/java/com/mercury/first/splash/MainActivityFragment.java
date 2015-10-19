package com.mercury.first.splash;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MainActivityFragment extends ListFragment {

    public MainActivityFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        String[] items=new String[40];
        for(int i=0; i<items.length;i++){
            items[i]="Item "+i;
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                getActivity().getApplicationContext(),
                R.layout.main_listview_item,
                R.id.main_list_item_text,items);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
