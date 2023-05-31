package com.example.projectmcs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    GridAdapter gridAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MedicSG> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        data = new ArrayList<>();
        for (int i=0 ; i<Meds.namaObat.length; i++){
            data.add(new MedicSG(
                    Meds.namaObat[i],
                    Meds.hargaObat[i],
                    Meds.manufaktur[i],
                    Meds.detailObat[i],
                    Meds.gambarObat[i]
            ));

        }
        gridAdapter = new GridAdapter(data);
        recyclerView.setAdapter(gridAdapter);

        gridAdapter.setOnItemClickCallBack(new GridAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(MedicSG data) {
                Intent myIntent = new Intent(getActivity(),MedsDetail.class);
                myIntent.putExtra("xNamaObat",data.getNamaObat());
                myIntent.putExtra("xManufaktur",data.getManufaktur());
                myIntent.putExtra("xGambarObat",data.gambarObat);
                myIntent.putExtra("xHargaObat",data.getHargaObat());
                myIntent.putExtra("xDetailObat",data.detailObat);
                startActivity(myIntent);
            }
        });


        return v;
    }
}