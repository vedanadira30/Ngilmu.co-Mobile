package com.example.ngilmu_co.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ngilmu_co.API.APIRequestData;
import com.example.ngilmu_co.API.RetroServer;
import com.example.ngilmu_co.R;
import com.example.ngilmu_co.adapter.AdapterDataTutor;
import com.example.ngilmu_co.model.ResponseModel;
import com.example.ngilmu_co.model.TutorModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PilihKursusActivity extends AppCompatActivity {
    //    private Context context;
//    private ImageView ivProfile;
//    private TextView tvNamaTutor, tvAlamatTutor, tvInstansi, tvIdTutor;
//    private RecyclerView rvDataTutor;
//    private RecyclerView.Adapter adDataTutor;
//    private RecyclerView.LayoutManager lmDataTutor;
//    private List<TutorModel> listDataTutor = new ArrayList<>();

    LinearLayout llTutor;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kursus);

        llTutor = findViewById(R.id.llTutor);

        llTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pilihJamal = new Intent(PilihKursusActivity.this, PilihTutorActivity.class);
                startActivity(pilihJamal);
            }
        });
//
//        rvDataTutor = findViewById(R.id.rvListTutor);
//        lmDataTutor = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        rvDataTutor.setLayoutManager(lmDataTutor);
//
//        retrieveDataTutor();
//
//    }
//
//    public void retrieveDataTutor(){
//         APIRequestData ardData = RetroServer.konekRetro().create(APIRequestData.class);
//         Call<ResponseModel> call = ardData.ardRetrieveDataTutor();
//
//         call.enqueue(new Callback<ResponseModel>() {
//             @Override
//             public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                 listDataTutor = response.body().getData_tutor();
//
//                 adDataTutor = new AdapterDataTutor(PilihKursusActivity.this, listDataTutor);
//                 rvDataTutor.setAdapter(adDataTutor);
//                 adDataTutor.notifyDataSetChanged();
//
//             }
//
//             @Override
//             public void onFailure(Call<ResponseModel> call, Throwable t) {
//                 Toast.makeText(PilihKursusActivity.this, "Tidak dapat menghubungi server!", Toast.LENGTH_SHORT).show();
//
//             }
//         });
//    }
    }
}