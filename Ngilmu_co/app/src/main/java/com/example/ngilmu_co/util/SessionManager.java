package com.example.ngilmu_co.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.se.omapi.Session;

import com.example.ngilmu_co.activities.MainActivity;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "prefs";
    public static final String IS_LOGIN = "IS_LOGIN";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PROFILE = "profile";
    public static final String KEY_GRADE = "grade";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_ALAMAT = "alamat";


    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
      public void createSession(String email){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }
      public void checkLogin(){
        if (!this.IS_LOGIN()){
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    private boolean IS_LOGIN() { return pref.getBoolean(IS_LOGIN, false);
    }


    public void logout(){
        editor.clear();
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_NAMA, pref.getString(KEY_NAMA, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        user.put(KEY_PROFILE, pref.getString(KEY_PROFILE, null));
        user.put(KEY_GRADE, pref.getString(KEY_GRADE, null));
        user.put(KEY_GENDER, pref.getString(KEY_GENDER, null));
        user.put(KEY_ALAMAT, pref.getString(KEY_ALAMAT, null));
        return user;
    }
}
