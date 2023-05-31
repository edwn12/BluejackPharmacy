package com.example.projectmcs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    public CardAdapter(ArrayList<TransSG> TransSGS) {
        this.TransSGS = TransSGS;
    }

    private ArrayList<TransSG> TransSGS;

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gr_design, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        TransSG trans = TransSGS.get(position);

        holder.namaObat.setText(trans.getNamaObat());
        holder.hargaObat.setText(trans.getHargaObat());
        holder.tanggal.setText(trans.getTanggal());
        holder.quantity.setText(trans.getQuantity());
        holder.gambarObat.setImageResource(trans.getGambarObat());
    }

    @Override
    public int getItemCount() {
        return TransSGS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaObat, hargaObat, tanggal, quantity;
        ImageView gambarObat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaObat = itemView.findViewById(R.id.namaObat);
            hargaObat = itemView.findViewById(R.id.hargaObat);
            tanggal = itemView.findViewById(R.id.tanggal);
            quantity = itemView.findViewById(R.id.quantity);
            gambarObat = itemView.findViewById(R.id.gambarObat);
        }
    }
}
