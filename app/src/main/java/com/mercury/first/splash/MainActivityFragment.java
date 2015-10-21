package com.mercury.first.splash;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivityFragment extends ListFragment {

    public static final String FRAGMENT_TAG = "com.mercury.first.splash.MainActivityFragment";

    private View headerView, footerView;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] items = new String[40];
        for (int i = 0; i < items.length; i++) {
            items[i] = "Item " + i;
        }
        adapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.main_listview_item,
                R.id.main_list_item_text, items);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (headerView != null) {
            ((TextView) headerView).setText(getString(R.string.main_header));
            this.getListView().addHeaderView(headerView, null, false);
            ((TextView) headerView).setText(getString(R.string.main_header));
            this.getListView().addFooterView(footerView, null, false);
        }
        this.setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        headerView = inflater.inflate(R.layout.main_list_header_footer, null);
        footerView = inflater.inflate(R.layout.main_list_header_footer, null);
        return v;
    }
}
