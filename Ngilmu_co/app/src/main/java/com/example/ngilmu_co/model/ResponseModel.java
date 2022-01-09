package com.example.ngilmu_co.model;

import java.util.List;

public class ResponseModel {
    private int kode;
    private String pesan;
    private List<UserModel> data_user;
    private List<TutorModel> data_tutor;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<TutorModel> getData_tutor() {
        return data_tutor;
    }

    public void setData_tutor(List<TutorModel> data_tutor) {
        this.data_tutor = data_tutor;
    }

    public List<UserModel> getData_user() {
        return data_user;
    }

    public void setData_user(List<UserModel> data_user) {
        this.data_user = data_user;
    }
}
