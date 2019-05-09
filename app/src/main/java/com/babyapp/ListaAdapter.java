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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;


public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private ArrayList<UsersInfo> dataset;
    private Context context;

    public ListaAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listainfo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UsersInfo usersInfo = dataset.get(position);
        holder.ediTextProducto.setText(usersInfo.getEditTextProducto());
        holder.editTextTienda.setText(usersInfo.getEditTextTienda());
        holder.editTextSucursal.setText(usersInfo.getEditTextSucursal());
        holder.editTextOferta.setText(usersInfo.getEditTextOferta());

        /*Glide.with(context)
                .load(usersInfo.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);*/
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaOfertas(ArrayList<UsersInfo> listaUsersInfo){
        dataset.addAll(listaUsersInfo);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView ediTextProducto;
        private TextView editTextTienda;
        private TextView editTextSucursal;
        private TextView editTextOferta;

        public ViewHolder(View itemView){
            super(itemView);

            ediTextProducto = (TextView) itemView.findViewById(R.id.editTextProducto);
            editTextTienda = (TextView) itemView.findViewById(R.id.editTextTienda);
            editTextSucursal = (TextView) itemView.findViewById(R.id.editTextSucursal);
            editTextOferta = (TextView) itemView.findViewById(R.id.editTextOferta);




        }
    }


}
