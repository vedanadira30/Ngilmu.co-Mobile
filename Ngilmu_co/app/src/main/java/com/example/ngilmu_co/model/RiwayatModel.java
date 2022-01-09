package com.example.ngilmu_co.model;
import com.google.gson.annotations.SerializedName;

public class RiwayatModel {
    //dr tb_pemesanan, tb user_detail, tb user_tutor, tb tabel_mapel
    @SerializedName("id_pemesanan")
    private int id_pemesanan;
    @SerializedName("id_user")
    private int id_user;
    @SerializedName("nama_user")
    private String fullname;
    @SerializedName("id_tutor")
    private int id_tutor;
    @SerializedName("nama_tutor")
    private String fullname_tutor ;
    @SerializedName("id_mapel")
    private int id_mapel;
    @SerializedName("mapel")
    private String mata_pelajaran;
    @SerializedName("tgl_pemesanan")
    private String tgl_pemesanan;
    @SerializedName("sesi_belajar")
    private String sesi_belajar;
    @SerializedName("harga")
    private int harga;

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getFullname_tutor() {
        return fullname_tutor;
    }

    public void setFullname_tutor(String fullname_tutor) {
        this.fullname_tutor = fullname_tutor;
    }

    public int getId_mapel() {
        return id_mapel;
    }

    public void setId_mapel(int id_mapel) {
        this.id_mapel = id_mapel;
    }

    public String getMata_pelajaran() {
        return mata_pelajaran;
    }

    public void setMata_pelajaran(String mata_pelajaran) {
        this.mata_pelajaran = mata_pelajaran;
    }

    public String getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(String tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public String getSesi_belajar() {
        return sesi_belajar;
    }

    public void setSesi_belajar(String sesi_belajar) {
        this.sesi_belajar = sesi_belajar;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
