package com.example.ngilmu_co.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ngilmu_co.R;
import com.example.ngilmu_co.activities.PilihKursusActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PencarianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PencarianFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PencarianFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PencarianFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PencarianFragment newInstance(String param1, String param2) {
        PencarianFragment fragment = new PencarianFragment();
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

    LinearLayout llsejarah;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pencarian, container, false);

        llsejarah = view.findViewById(R.id.llsejarah);

        llsejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Melakukan Intent Explicit ke Activity Pilih Kursus
                Intent pilihsejarah = new Intent(getActivity(), PilihKursusActivity.class);
                startActivity(pilihsejarah);
            }
        });

        return view;

    }
}