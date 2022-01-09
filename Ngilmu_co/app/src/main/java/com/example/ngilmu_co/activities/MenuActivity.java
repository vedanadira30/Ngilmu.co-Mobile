package com.example.ngilmu_co.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.ngilmu_co.fragment.BerandaFragment;
import com.example.ngilmu_co.fragment.PencarianFragment;
import com.example.ngilmu_co.fragment.ProfilFragment;
import com.example.ngilmu_co.R;

public class MenuActivity extends AppCompatActivity {

    //Mendeklarasikan Program
    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BerandaFragment()).commit();
        //Menambahkan icon vector dari drawable
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_search));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_profile));
        //Memberikan fungsi interatif agar fragment dapat berpindah ketika button diberi sebuah aksi

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment selectedFragment = null;

                switch (item.getId()) {
                    case 1:
                        selectedFragment = new BerandaFragment();
                        break;
                    case 2:
                        selectedFragment = new PencarianFragment();
                        break;
                    case 3:
                        selectedFragment = new ProfilFragment();
                        break;
                }

                loadFragment(selectedFragment);

            }
        });

        //Menampilkan notifikasi ketika button menerima sebuah aksi
        bottomNavigation.setCount(3, "5");
        bottomNavigation.show(2, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "You Clicked " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "You Reselected " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Menjalankan program
    private void loadFragment(Fragment selectedFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
    }
}