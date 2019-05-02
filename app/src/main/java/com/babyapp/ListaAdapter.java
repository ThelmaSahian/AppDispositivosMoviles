package com.babyapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class ListaAdapter extends ArrayAdapter<UsersInfo> {

    private ArrayList<UsersInfo> usersInfos;
    private LayoutInflater layoutInflater;
    private int viewResourceID;

    public ListaAdapter(Context context, int textViewResourceID, ArrayList<UsersInfo> usersInfos){
        super(context, textViewResourceID, usersInfos);
        this.usersInfos = usersInfos;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewResourceID = textViewResourceID;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        convertView = layoutInflater.inflate(viewResourceID, null);
        UsersInfo usersInfo = usersInfos.get(position);

        if(usersInfo != null){
            EditText editTextProducto = convertView.findViewById(R.id.editTextProducto);
            EditText editTextTienda = convertView.findViewById(R.id.editTextTienda);
            EditText editTextSucursal = convertView.findViewById(R.id.editTextSucursal);
            EditText editTextOferta = convertView.findViewById(R.id.editTextOferta);

            if(editTextProducto != null){
                editTextProducto.getText();
            }
        }



        return convertView;
    }

}
