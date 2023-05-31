package com.example.projectmcs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {
    RecyclerView recyclerView;
    CardAdapter cardAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<TransSG> data = MedsDetail.TransData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewTr);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        cardAdapter = new CardAdapter(data);
        recyclerView.setAdapter(cardAdapter);

        return view;
    }
}