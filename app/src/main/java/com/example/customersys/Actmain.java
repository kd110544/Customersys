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

            startActivityForResult(new Intent(Actmain.this, ActList.class),1997);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1997){
            if(data==null){
                return;
            }
            if(data.getExtras()==null){
                return;
            }

            int position = Integer.parseInt(data.getExtras().getString("GGG"));
            factory.MoveTo(position);
            DisplayCustomerInfo();
            //txtId.setText("收到"+position);
            //txtName.setText("收到"+position);
            //txtPhone.setText("收到"+position);
            //txtEmail.setText("收到"+position);
            //txtAddress.setText("收到"+position);



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
