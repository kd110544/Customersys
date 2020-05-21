package com.example.customersys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actmain extends Activity {

    CCustomerFactory factory = new CCustomerFactory();

    private void DisplayCustomerInfo() {
        txtId.setText(factory.GetCurrent().getId());
        txtName.setText(factory.GetCurrent().getName());
        txtPhone.setText(factory.GetCurrent().getPhone());
        txtEmail.setText(factory.GetCurrent().getEmail());
        txtAddress.setText(factory.GetCurrent().getAddress());
    }




    private View.OnClickListener btnFirst_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveFirst();
            DisplayCustomerInfo();

        }
    };
    private View.OnClickListener btnPrevious_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MovePrevious();
            DisplayCustomerInfo();

        }
    };

    private View.OnClickListener btnNext_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveNext();
            DisplayCustomerInfo();

        }
    };

    private View.OnClickListener btnLast_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveLast();
            DisplayCustomerInfo();

        }
    };
    private View.OnClickListener btnSearch_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };
    private View.OnClickListener btnList_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String[] customers = new String[factory.GetAll().length];
            for (int i=0;i<customers.length;i++){
                customers[i]=factory.GetAll()[i].getName()+
                        "\r\n"+factory.GetAll()[i].getPhone()+
                        " / "+factory.GetAll()[i].getEmail();
            }

            Bundle bund = new Bundle();
            bund.putStringArray(CDictionary.BK_CUSTOMER_NAMES_LIST,customers);
            Intent intent = new Intent(Actmain.this, ActList.class);
            intent.putExtras(bund);
            startActivityForResult(intent, CDictionary.AID_ACTLIST);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CDictionary.AID_ACTLIST){
            if(data==null){
                return;
            }
            if(data.getExtras()==null){
                return;
            }

            int position = data.getExtras().getInt(CDictionary.BK_SELECTED_CUSTOMER_POSITION);
            factory.MoveTo(position);
            DisplayCustomerInfo();

        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }

    private void InitialComponent() {
        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);

        btnFirst = findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(btnFirst_Click);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnPrevious.setOnClickListener(btnPrevious_Click);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(btnNext_Click);
        btnLast = findViewById(R.id.btnLast);
        btnLast.setOnClickListener(btnLast_Click);

        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(btnSearch_Click);
        btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(btnList_Click);

    }
    EditText txtId;
    EditText txtName;
    EditText txtPhone;
    EditText txtEmail;
    EditText txtAddress;
    Button btnFirst;
    Button btnPrevious;
    Button btnNext;
    Button btnLast;
    Button btnSearch;
    Button btnList;


}
