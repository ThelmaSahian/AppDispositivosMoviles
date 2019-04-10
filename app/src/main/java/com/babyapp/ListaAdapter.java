package com.babyapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;


public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder> {

    private ArrayList<UsersInfo> datase;
    private Context context;

    public ListaAdapter(Context context){
        this.context = context;
        datase = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_publicaciones, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        UsersInfo usersInfo = datase.get(position);

    }

    @Override
    public int getItemCount() {
        return datase.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }
}
