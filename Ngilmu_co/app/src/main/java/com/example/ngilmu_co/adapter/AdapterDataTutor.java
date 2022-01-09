package com.example.ngilmu_co.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ngilmu_co.API.APIRequestData;
import com.example.ngilmu_co.API.RetroServer;
import com.example.ngilmu_co.R;
import com.example.ngilmu_co.activities.PilihTutorActivity;
import com.example.ngilmu_co.model.ResponseModel;
import com.example.ngilmu_co.model.TutorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterDataTutor extends RecyclerView.Adapter<AdapterDataTutor.HolderDataTutor> {
    private Context context;
    private String id_tutor;
    private List<TutorModel> listDataTutor;

    public AdapterDataTutor(Context context, List<TutorModel> listDataTutor) {
        this.context = context;
        this.listDataTutor = listDataTutor;
    }

    @NonNull
    @Override
    public HolderDataTutor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tutor, parent, false);
        HolderDataTutor holderDataTutor = new HolderDataTutor(layout);
        return holderDataTutor;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataTutor holder, int position) {
        TutorModel dataTutor = listDataTutor.get(position);

//        String urlProfile = dataTutor.getProfile();
//        Glide.with(context)
//                .load(urlProfile) //load dr db
//                .placeholder(R.drawable.tutor_male)
//                .error(R.drawable.ic_kimia)
//                .into(holder.ivProfile);

        holder.tvIdTutor.setText(String.valueOf(dataTutor.getId_tutor()));
        holder.tvNamaTutor.setText(dataTutor.getFullname_tutor());
        holder.tvInstansi.setText(dataTutor.getInstansi());
        holder.tvAlamatTutor.setText(dataTutor.getAlamat());

    }

    @Override
    public int getItemCount() {
        return listDataTutor.size();
    }

    public class HolderDataTutor extends RecyclerView.ViewHolder {
        ImageView ivProfile;
        TextView tvNamaTutor, tvAlamatTutor, tvInstansi, tvIdTutor;

        public HolderDataTutor(@NonNull View itemView) {
            super(itemView);
//            ivProfile = itemView.findViewById(R.id.ivProfile);
            tvNamaTutor = itemView.findViewById(R.id.tvNamaTuTor);
            tvAlamatTutor = itemView.findViewById(R.id.tvAlamatTutor);
            tvInstansi = itemView.findViewById(R.id.tvInstansi);
            tvIdTutor = itemView.findViewById(R.id.tvIdTutor);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    id_tutor = Integer.parseInt(tvIdTutor.getText().toString());
//                    getTutorModel();
//                }
//            });
        }
    }
}
//        private void getTutorModel() {
//            APIRequestData apiRequestData = RetroServer.konekRetro().create(APIRequestData.class);
//            Call<ResponseModel> call = apiRequestData.ardGetDataTutor(id_tutor);
//
//            call.enqueue(new Callback<ResponseModel>() {
//                @Override
//                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                    listDataTutor = response.body().getData_tutor();
//
//                    String varIdTutor = listDataTutor.get(0).getId_tutor();
//                    String varFullname = listDataTutor.get(0).getFullname_tutor();
//                    String varAlamat = listDataTutor.get(0).getAlamat();
//                    String varInstansi = listDataTutor.get(0).getInstansi();
//                    String varProfile = listDataTutor.get(0).getProfile();
//
//                    Intent send = new Intent(context, PilihTutorActivity.class);
//                    send.putExtra("id_tutor", varIdTutor);
//                    send.putExtra("fullname_tutor", varFullname);
//                    send.putExtra("alamat", varAlamat);
//                    send.putExtra("instansi", varInstansi);
//                    send.putExtra("profile", varProfile);
//                    context.startActivity(send);
//
//                    }
//
//                @Override
//                public void onFailure(Call<ResponseModel> call, Throwable t) {
//                    Toast.makeText(context, "Tidak dapat menghubungi server!" +t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }
//
//    }
//}
