package com.mercury.first.splash;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFragment extends ListFragment {

    public static final String FRAGMENT_TAG = "com.mercury.first.splash.MainActivityFragment";

    private View headerView, footerView;
    private MyArrayAdapter adapter;
    private String[] items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new String[40];
        for (int i = 0; i < items.length; i++) {
            items[i] = "Item " + i;
        }
        adapter = new MyArrayAdapter(getActivity(), R.layout.main_listview_item, items);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (headerView != null) {
            ((TextView) headerView).setText(getString(R.string.main_header));
            this.getListView().addHeaderView(headerView, null, false);
            ((TextView) footerView).setText(getString(R.string.main_footer));
            this.getListView().addFooterView(footerView, null, false);
        }
        this.setListAdapter(adapter);
        getListView().setDivider(getResources().getDrawable(android.R.color.transparent));
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getString(R.string.alert_header))
                        .setMessage(((TextView) view.findViewById(R.id.main_list_item_text)).getText() + " was clicked")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setCancelable(false)
                        .create()
                        .show();
                return false;
            }
        });
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ((TextView) view.findViewById(R.id.main_list_item_text)).getText() + " was clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        headerView = inflater.inflate(R.layout.main_list_header_footer, null);
        footerView = inflater.inflate(R.layout.main_list_header_footer, null);
        return v;
    }

    private class MyArrayAdapter extends ArrayAdapter<String> {

        private final int COLORS[] = getResources().getIntArray(R.array.rainbow);

        public MyArrayAdapter(Context c, int resId, String[] items) {
            super(c, resId, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String item = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.main_listview_item, null);
            }
            ((TextView) convertView.findViewById(R.id.main_list_item_text)).setText(item);
            ((ImageView) convertView.findViewById(R.id.main_list_item_circle)).setColorFilter(COLORS[position % 8], PorterDuff.Mode.MULTIPLY);
            return convertView;
        }
    }

}
