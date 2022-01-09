package com.example.ngilmu_co.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ngilmu_co.API.APIRequestData;
import com.example.ngilmu_co.API.RetroServer;
import com.example.ngilmu_co.R;
import com.example.ngilmu_co.activities.Login;
import com.example.ngilmu_co.activities.UpdateDataActivity;
import com.example.ngilmu_co.model.ResponseModel;
import com.example.ngilmu_co.model.UserModel;
import com.example.ngilmu_co.util.SessionManager;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilFragment newInstance(String param1, String param2) {
        ProfilFragment fragment = new ProfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Context context;
    private ImageView ivProfil;
    private TextView tvNamaHeader, tvNama, tvEmailHeader, tvEmail, tvGrade, tvGender, tvAlamat;
    private List<UserModel> listDataUser;
    private String email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        SessionManager sessionManager = new SessionManager(getActivity());
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetails();
        email = user.get(SessionManager.KEY_EMAIL);

        getData();

//        ivProfil = view.findViewById(R.id.ivProfil);
//        tvNamaHeader = view.findViewById(R.id.tvNamaHeader);
//        tvEmailHeader = view.findViewById(R.id.tvEmailHeader);
//        tvNama = view.findViewById(R.id.tvNama);
//        tvEmail = view.findViewById(R.id.tvEmail);
//        tvGrade = view.findViewById(R.id.tvGrade);
//        tvGender = view.findViewById(R.id.tvGender);
//        tvAlamat = view.findViewById(R.id.tvAlamat);

//        Button btnPerbarui = view.findViewById(R.id.btnPerbarui);
//        btnPerbarui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getID();
//            }
//        });
//
//        Button btnKeluar = view.findViewById(R.id.btnKeluar);
//        btnKeluar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder dialogPesan = new AlertDialog.Builder(getActivity());
//                dialogPesan.setTitle("Perhatian!");
//                dialogPesan.setIcon(R.drawable.ic_error);
//                dialogPesan.setMessage("Apakah anda yakin ingin keluar?");
//                dialogPesan.setCancelable(true);
//
//                dialogPesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                        sessionManager.logout();
//                        Intent ii = new Intent(getActivity(), Login.class);
//                        startActivity(ii);
//                        getActivity().finish();
//                        Toast.makeText(getActivity(), "Anda berhasil keluar!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialogPesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//                dialogPesan.show();
//            }
//        });

        return view;
    }
//}

    private void getData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> ambilData = ardData.ardRetrieveUser(email);
        ambilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                if (kode == 200) {
                    listDataUser = response.body().getData_user();

//                    String varEmail = listDataUser.get(0).getEmail();
//                    String varNama = listDataUser.get(0).getFullname();
//                    String varGrade = listDataUser.get(0).getGrade();
//                    String varGender = listDataUser.get(0).getGender();
//                    String varAlamat = listDataUser.get(0).getAlamat();
//                    String varProfile = listDataUser.get(0).getProfile();
//
//                    Glide.with(getActivity())
//                            .load(varProfile)// load gambar dari database
//                            .placeholder(R.drawable.tutor_male)// tampil awal sebelum load gambar dari data
//                            .error(R.drawable.ic_error) // jika load error
//                            .into(ivProfil);
//
//                    tvNamaHeader.setText(varNama);
//                    tvEmailHeader.setText(varEmail);
//                    tvEmail.setText(varEmail);
//                    tvNama.setText(varNama);
//                    tvEmail.setText(varEmail);
//                    tvGrade.setText(varGrade);
//                    tvGender.setText(varGender);
//                    tvAlamat.setText(varAlamat);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
            }
        });
    }
//
//    private void getID() {
//        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
//        Call<ResponseModel> ambilID = ardData.ardRetrieveUser(email);
//        ambilID.enqueue(new Callback<ResponseModel>() {
//            @Override
//            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                listDataUser = response.body().getData_user();
//
//                String varId = listDataUser.get(0).getId_user();
//
//
//                Intent kirim = new Intent(getActivity(), UpdateDataActivity.class); // kirim id ke PerbaruiDataActivity
//                kirim.putExtra("id", varId);
//                startActivity(kirim);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseModel> call, Throwable t) {
//            }
//        });
//    }
//}

//    private Context context;
////    private ImageView ivProfil;
//    private TextView tvNamaHeader, tvEmailHeader, tvNama, tvEmail, tvGrade, tvGender, tvAlamat;
//    private List<UserModel> listDataUser;
//    private String email;
//    private SharedPreferences sharedPreferences;
//
//    private static final String SHARED_PREF_NAME = "mypref";
//    private static  final String KEY_EMAIL = "email";
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_profil, container, false);
//
//        SessionManager sessionManager = new SessionManager(getActivity());
//        sessionManager.checkLogin();
//
//        HashMap<String, String> user = sessionManager.getUserDetails();
//        email = user.get(SessionManager.KEY_EMAIL);
//
//        RetrieveDataUser();
//
////        ivProfil = view.findViewById(R.id.ivProfil);
//        tvNamaHeader = view.findViewById(R.id.tvNamaHeader);
//        tvEmailHeader = view.findViewById(R.id.tvEmailHeader);
//        tvNama = view.findViewById(R.id.tvNama);
//        tvEmail = view.findViewById(R.id.tvEmail);
//        tvGrade = view.findViewById(R.id.tvGrade);
//        tvGender = view.findViewById(R.id.tvGender);
//        tvAlamat = view.findViewById(R.id.tvAlamat);
//
//        Button btnPerbarui = view.findViewById(R.id.btnPerbarui);
//        btnPerbarui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getId();
//            }
//        });
//
//        return view;
//    }
//
//    private void RetrieveDataUser(){
//        APIRequestData ardData = RetroServer.konekRetro().create(APIRequestData.class);
//        Call<ResponseModel> call = ardData.ardRetrieveUser(email);
//        call.enqueue(new Callback<ResponseModel>() {
//            @Override
//            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                if (response.isSuccessful()) {
//
//                    listDataUser = response.body().getData_user();
//
//                    String varEmail = listDataUser.get(0).getEmail();
//                    String varFullname = listDataUser.get(0).getFullname();
//                    String varAlamat = listDataUser.get(0).getAlamat();
//                    String varGrade = listDataUser.get(0).getGrade();
//                    String varGender = listDataUser.get(0).getGender();
//
////                Glide.with(getActivity())
////                        .load(varProfil)
////                        .placeholder(R.drawable.tutor_male)
////                        .error(R.drawable.tutor_female)
////                        .into(ivProfil);
//
//                    tvEmail.setText(varEmail);
//                    tvEmailHeader.setText(varEmail);
//                    tvNamaHeader.setText(varFullname);
//                    tvNama.setText(varFullname);
//                    tvGrade.setText(varGrade);
//                    tvGender.setText(varGender);
//                    tvAlamat.setText(varAlamat);
//                } else {
//                    Toast.makeText(getActivity().getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<ResponseModel> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void getID(){
//        APIRequestData ardData = RetroServer.konekRetro().create(APIRequestData.class);
//        Call<ResponseModel> call = ardData.ardRetrieveUser(email);
//        call.enqueue(new Callback<ResponseModel>() {
//            @Override
//            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                listDataUser = response.body().getData_user();
//
//                String varIdUser = listDataUser.get(0).getId_user();
//
//                Intent send = new Intent(getActivity(), UpdateDataActivity.class);
//                send.putExtra("id_user", varIdUser);
//                startActivity(send);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseModel> call, Throwable t) {
//
//            }
//        });
//    }
}