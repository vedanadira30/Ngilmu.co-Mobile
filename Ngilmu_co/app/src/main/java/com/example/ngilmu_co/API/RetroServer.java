package com.example.ngilmu_co.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

    private static String base_url = "http://192.168.43.124/ngilmu.co/";

   private static RetroServer mInstance;
    private static Retrofit retro;

    public static Retrofit konekRetrofit() {
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retro;
    }

    private RetroServer() {
        retro = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetroServer getInstance() {
        if (mInstance == null) {
            mInstance = new RetroServer();
        }
        return mInstance;
    }

    public static APIRequestData getAPI(){
        return retro.create(APIRequestData.class);
    }

}

//    public static Retrofit retrofit;
//
//    public static Retrofit konekRetro(){
//        if (retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(base_url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//}
