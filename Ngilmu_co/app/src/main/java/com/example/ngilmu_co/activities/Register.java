package com.example.ngilmu_co.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ngilmu_co.API.APIRequestData;
import com.example.ngilmu_co.API.RetroServer;
import com.example.ngilmu_co.R;
import com.example.ngilmu_co.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

//    // spinner grade data
//    String[] list_gender = {"Laki-Laki", "Perempuan"};
//    String[] list_school = {"SD", "SMP", "SMA/SMK"};
//    String[] list_grade_sd = {"1", "2", "3", "4", "5", "6"};
//    String[] list_grade_smp = {"7", "8", "9"};
//    String[] list_grade_sma_smk = {"10", "11", "12"};
//
//    // comp
//    private TextView txt_masuk;
//    private EditText txt_email, txt_password, txt_fullname, txt_address;
//    private CardView btn_daftar;
//    private Spinner cb_grade, cb_school, cb_gender;
//    private ArrayAdapter<String> adapter_gender, adapter_grade, adapter_school;
//
//    // var data
//    private String fullname, gender, grade, address, email, password, konfirmasi_password;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        // init
//        txt_masuk = findViewById(R.id.txt_masuk);
//        txt_address = findViewById(R.id.txt_address);
//        txt_fullname = findViewById(R.id.txt_fullname);
//        txt_email = findViewById(R.id.txt_email);
//        txt_password = findViewById(R.id.txt_password);
//        btn_daftar = findViewById(R.id.btn_daftar);
//        cb_gender = findViewById(R.id.cb_gender);
//        cb_grade = findViewById(R.id.cb_grade);
//        cb_school = findViewById(R.id.cb_school);
//
//        // set adapter value
//        adapter_gender = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list_gender);
//        cb_gender.setAdapter(adapter_gender);
//        adapter_school = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list_school);
//        cb_school.setAdapter(adapter_school);
//
//
//        // set data for grade
//        cb_school.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String val = cb_school.getSelectedItem().toString();
//                if ("SD".equals(val)) {
//                    setAdapter_grade(list_grade_sd);
//                } else if ("SMP".equals(val)) {
//                    setAdapter_grade(list_grade_smp);
//                } else if ("SMA/SMK".equals(val)) {
//                    setAdapter_grade(list_grade_sma_smk);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        // event
//        txt_masuk.setOnClickListener(v -> {
//            startActivity(new Intent(getApplicationContext(), Login.class));
//        });
//
//        btn_daftar.setOnClickListener(v -> {
//            // get all data
//            fullname = txt_fullname.getText().toString();
//            address = txt_address.getText().toString();
//            email = txt_email.getText().toString();
//            password = txt_password.getText().toString();
//            grade = cb_grade.getSelectedItem().toString();
//            gender = cb_gender.getSelectedItem().toString();
//
//            // send the data
//            APIRequestData apiRequestData = RetroServer.konekRetro().create(APIRequestData.class);
//            Call<ResponseModel> call = apiRequestData.ardCreateUser(email, password, fullname, grade, gender, address);
//            call.enqueue(new Callback<ResponseModel>() {
//                @Override
//                public void onResponse(@NonNull Call<ResponseModel> call, Response<ResponseModel> response) {
//                    assert response.body() != null;
//                    Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), Login.class));
//                }
//
//                @Override
//                public void onFailure(@NonNull Call<ResponseModel> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        });
//
//    }
//
//    private void setAdapter_grade(String[] list) {
//        adapter_grade = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
//        cb_grade.setAdapter(adapter_grade);
//    }
}