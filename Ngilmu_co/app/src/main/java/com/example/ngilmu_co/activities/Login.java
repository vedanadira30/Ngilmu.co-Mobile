package com.example.ngilmu_co.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ngilmu_co.API.APIRequestData;
import com.example.ngilmu_co.API.RetroServer;
import com.example.ngilmu_co.R;
import com.example.ngilmu_co.model.ResponseModel;
import com.example.ngilmu_co.model.UserModel;
import com.example.ngilmu_co.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText txt_email, txt_password;
    private String email, password;
    private CardView btn_masuk;
    private TextView txt_daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);

        btn_masuk = findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txt_email.getText().toString().trim();
                password = txt_password.getText().toString().trim();

                if (email.isEmpty()) {
                    txt_email.setError("Email tidak boleh kosong!");
                    txt_email.requestFocus();
                } else if (password.isEmpty()) {
                    txt_password.setError("Password tidak boleh kosong!");
                    txt_password.requestFocus();
                } else {
                    userLogin(email, password);
                }
            }
        });
    }

    public void userLogin(String email, String password) {
        APIRequestData ardData = RetroServer.getInstance().getAPI();
        Call<ResponseModel> userLogin = ardData.ardGetUserLogin(email, password);
        userLogin.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                if (kode == 200) {
                    SessionManager sessionManager = new SessionManager(getApplicationContext());
                    String email = txt_email.getText().toString();
                    sessionManager.createSession(email);

                    Toast.makeText(Login.this, "Kode: " +kode +" | Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, MenuActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Kode: " +kode +" | Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(Login.this, "Gagal login: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void actionDaftar(View view) {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }

}