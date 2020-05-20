package com.example.customersys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ActList extends ListActivity {

    CCustomerFactory factory = new CCustomerFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CCustomer c0 = factory.GetAll()[0];
        CCustomer c1 = factory.GetAll()[1];
        CCustomer c2 = factory.GetAll()[2];
        CCustomer c3 = factory.GetAll()[3];
        CCustomer c4 = factory.GetAll()[4];

        //String[] user2 = factory.GetAll()[0];
        String[] user = {c0.getName()+" / " +c0.getEmail(),
                c1.getName()+" / " +c1.getEmail(),
                c2.getName()+" / " +c2.getEmail(),
                c3.getName()+" / " +c3.getEmail(),
                c4.getName()+" / " +c4.getEmail()};
        ListAdapter adapter = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        user);
        setListAdapter(adapter);




    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bund = new Bundle();
        bund.putString("GGG",String.valueOf(position));
        Intent intent = new Intent();
        intent.putExtras(bund);

        setResult(0,intent);
        finish();
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
