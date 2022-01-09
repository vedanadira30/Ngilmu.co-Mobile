package com.example.ngilmu_co.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ngilmu_co.R;

public class PilihTutorActivity extends AppCompatActivity {

    Button btn_belajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_tutor);

        btn_belajar = findViewById(R.id.btn_belajar);

        btn_belajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mulaiBelajar = new Intent(PilihTutorActivity.this, PaymentActivity.class);
                startActivity(mulaiBelajar);
            }
        });
    }
}