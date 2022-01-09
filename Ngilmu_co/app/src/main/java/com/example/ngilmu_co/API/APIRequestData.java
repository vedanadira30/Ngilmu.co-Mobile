package com.example.ngilmu_co.API;


import com.example.ngilmu_co.model.ResponseModel;
import com.example.ngilmu_co.model.RiwayatModel;
import com.example.ngilmu_co.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {

    @GET("retrieve_tutor.php")
    Call<ResponseModel> ardRetrieveDataTutor();

    @FormUrlEncoded
    @POST("retrieve_tutor.php")
    Call<ResponseModel> ardGetDataTutor(
            @Field("id_tutor") String id_tutor);

    @FormUrlEncoded
    @POST("retrieve_data_riwayat.php")
    Call<ResponseModel> ardRetrieveDataRiwayat(
            @Field("id_pemesanan") int id_pemesanan);

    @FormUrlEncoded
    @POST("userlogin.php")
    Call<ResponseModel> ardGetUserLogin(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateUser(@Field("email") String email,
                                      @Field("password") String password,
                                      @Field("fullname") String fullname,
                                      @Field("grade") String grade,
                                      @Field("gender") String gender,
                                      @Field("alamat") String alamat);

    @FormUrlEncoded
    @POST("retrieve_user.php")
    Call<ResponseModel> ardRetrieveUser(@Field("email") String email);

//    @FormUrlEncoded
//    @POST("retrieve_tutor.php")
//    Call<ResponseModel> ardRetrieveDataTutor(
//            @Field("id_tutor") String id_tutor);
}