package com.example.customersys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class ActList extends ListActivity {

    CCustomerFactory factory = new CCustomerFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);//wrong
        InitialComponent();
    }

    private void InitialComponent() {
        String[] user = {"1","1","1","1","1","1"};
        ListAdapter adapter = new ArrayAdapter<String>
                (this,
                android.R.layout.simple_list_item_1,
                        user);
        setListAdapter(adapter);
    }
}
