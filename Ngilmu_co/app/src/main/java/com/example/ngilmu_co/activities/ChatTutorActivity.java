package com.example.ngilmu_co.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ngilmu_co.R;

public class ChatTutorActivity extends AppCompatActivity {

    ImageView imv_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_tutor);

        imv_chat = findViewById(R.id.imv_chat);
    }

    public void openWA(View view) {
        String number = "6285811171162";
        String url = "https://api.whatsapp.com/send?phone="+number;
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setPackage("com.whatsapp");

        i.setData(Uri.parse(url));
        startActivity(i);
    }
}