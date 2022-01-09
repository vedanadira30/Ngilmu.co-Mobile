package com.example.ngilmu_co.adapter;

import android.content.Context;
import android.hardware.lights.LightState;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ngilmu_co.model.RiwayatModel;

import java.util.List;

public class AdapterDataRiwayat {
    private Context context;
    private List<RiwayatModel> listDataRiwayat;
    private int id_pemesanan;

    public AdapterDataRiwayat(Context context, List<RiwayatModel> listDataRiwayat) {
        this.context = context;
        this.listDataRiwayat = listDataRiwayat;
    }
}


