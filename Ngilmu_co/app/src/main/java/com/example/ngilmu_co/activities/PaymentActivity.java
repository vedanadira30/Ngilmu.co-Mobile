package com.example.ngilmu_co.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.ngilmu_co.R;

public class PaymentActivity extends AppCompatActivity {

    RelativeLayout rlCod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        rlCod = findViewById(R.id.rl_cod);

        rlCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pilihCod = new Intent(PaymentActivity.this, ChatTutorActivity2.class);
                startActivity(pilihCod);
            }
        });
    }
}