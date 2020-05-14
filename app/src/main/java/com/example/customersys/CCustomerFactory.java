package com.example.customersys;

import android.speech.SpeechRecognizer;

import java.util.ArrayList;

public class CCustomerFactory {
    ArrayList<CCustomer> list = new ArrayList<CCustomer>();
    int position;

    public void LoadData(){
        list.add(new CCustomer("A001","Jeff","0933805198","kd110544@gmail.com","taiwan520"));
        list.add(new CCustomer("B002","Gary","0912345678","gary@gmail.com","taiwan118"));
        list.add(new CCustomer("C003","Carrie","0987654321","sunshine@gmail.com","taiwan666"));
    }
    public void MoveFirst(){
        position=0;

    }
    public void MovePrevious(){
        position--;
        if (position<0)
            position =0;
    }
    public void MoveNext(){
        position++;
        if(position>=0)
            MoveLast();
    }
    public void MoveLast(){
        position=list.size()-1;
    }
    public void MoveTo(int to){
        position=to;
    }
    public CCustomer GetCurrent(){
        return list.get(position);
    }
    public CCustomer[] GetAll(){
        return list.toArray(new CCustomer[list.size()]);

    }
}
