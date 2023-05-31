package com.example.projectmcs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    public GridAdapter(ArrayList<MedicSG> medicSGS) {
        this.medicSGS = medicSGS;
    }

    private ArrayList<MedicSG> medicSGS;
    public interface OnItemClickCallBack{
        void onItemClicked(MedicSG data);
    }

    private OnItemClickCallBack callback;

    public void setOnItemClickCallBack(OnItemClickCallBack callback) {
        this.callback = callback;
    }


    @NonNull
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_design, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.ViewHolder holder, int position) {
        MedicSG medic = medicSGS.get(position);

        holder.namaObat.setText(medic.getNamaObat());
        holder.hargaObat.setText(medic.getHargaObat());
        holder.manufaktur.setText(medic.getManufaktur());
        holder.gambarObat.setImageResource(medic.getGambarObat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(medicSGS.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {

        return medicSGS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaObat, hargaObat, manufaktur;
        ImageView gambarObat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaObat = itemView.findViewById(R.id.namaObat);
            hargaObat = itemView.findViewById(R.id.hargaObat);
            manufaktur = itemView.findViewById(R.id.manufaktur);
            gambarObat = itemView.findViewById(R.id.gambarObat);
        }
    }
}
