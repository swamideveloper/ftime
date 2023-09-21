package com.ff.guide.mukesh_ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.io.File;
import java.util.ArrayList;

public class pro_sdk_c {
    SharedPreferences pref;
    Editor edit;

    private static final String IS_FIRSTTIME_USE = "is_firsttime_use";
    private static final String inter_count = "inter_count";
    private static final String back_cnt = "back_cnt";
    private static final String AM_APP_ID = "am_app_id";
    private static final String AM_App_Open = "am_app_open";
    private static final String AM_inter = "AM_inter";
    private static final String AM_native = "AM_native";
    private static final String AM_banner = "AM_banner";
    private static final String FB_app_id = "FB_app_id";
    private static final String FB_inter = "FB_inter";
    private static final String FB_native = "FB_native";
    private static final String FB_native_banner = "FB_native_banner";
    private static final String FB_banner = "FB_banner";
    private static final String AM_Rectangele = "AM_Rectangele";


    private static final String Duo_Ads = "Duo_Ads";
    private static final String Qureka_Inter = "Qureka_Inter";
    private static final String Qureka_Inter_Mode = "Qureka_Inter_Mode";
    private static final String Qureka_Inter_CloseTap = "Qureka_Inter_CloseTap";
    private static final String Qureka_Url = "Qureka_Url";

    //App-----------------------------
    private static final String App_Country = "App_Country";
    private static final String App_Privacy = "App_Privacy";
    private static final String App_Language = "App_Language";
    private static final String App_Permission = "App_Permission";
    private static final String App_Start = "App_Start";
    private static final String App_Thankyou = "App_Thankyou";
    private static final String App_Exit_Dialoge = "App_Exit_Dialoge";

    //Call
    private static final String IsLongApp = "IsLongApp";
    private static final String Video_call = "Video_call";
    private static final String Incoming_Welcome = "Incoming_Welcome";
    private static final String Incoming_Counter = "Incoming_Counter";



    public pro_sdk_c(Context c) {
        pref = c.getSharedPreferences("file_pref", Context.MODE_PRIVATE);
        edit = pref.edit();
    }

    public String getAmAppId() {
        String userID = pref.getString(AM_APP_ID, "");
        return userID;
    }

    public void setAmAppId(String color) {
        edit.putString(AM_APP_ID, color);
        edit.commit();
    }

    public String getAM_App_Open() {
        String userID = pref.getString(AM_App_Open, "");
        return userID;
    }

    public void setAM_App_Open(String color) {
        edit.putString(AM_App_Open, color);
        edit.commit();
    }

    public String getAM_inter() {
        String userID = pref.getString(AM_inter, "");
        return userID;
    }

    public void setAM_inter(String color) {
        edit.putString(AM_inter, color);
        edit.commit();
    }

    public String getAM_native() {
        String userID = pref.getString(AM_native, "");
        return userID;
    }

    public void setAM_native(String color) {
        edit.putString(AM_native, color);
        edit.commit();
    }

    public String getAM_banner() {
        String userID = pref.getString(AM_banner, "");
        return userID;
    }

    public void setAM_banner(String color) {
        edit.putString(AM_banner, color);
        edit.commit();
    }

    public String getFB_app_id() {
        String userID = pref.getString(FB_app_id, "");
        return userID;
    }

    public void setFB_app_id(String color) {
        edit.putString(FB_app_id, color);
        edit.commit();
    }

    public String getFB_inter() {
        String userID = pref.getString(FB_inter, "");
        return userID;
    }

    public void setFB_inter(String color) {
        edit.putString(FB_inter, color);
        edit.commit();
    }

    public String getFB_native() {
        String userID = pref.getString(FB_native, "");
        return userID;
    }

    public void setFB_native(String color) {
        edit.putString(FB_native, color);
        edit.commit();
    }

    public String getFB_native_banner() {
        String userID = pref.getString(FB_native_banner, "");
        return userID;
    }

    public void setFB_native_banner(String color) {
        edit.putString(FB_native_banner, color);
        edit.commit();
    }

    public String getFB_banner() {
        String userID = pref.getString(FB_banner, "");
        return userID;
    }

    public void setFB_banner(String color) {
        edit.putString(FB_banner, color);
        edit.commit();
    }

    public String getAM_Rectangele() {
        String userID = pref.getString(AM_Rectangele, "");
        return userID;
    }

    public void setAM_Rectangele(String color) {
        edit.putString(AM_Rectangele, color);
        edit.commit();
    }

    //-----------------------------------------------------------------------------------------------

    public String getDuo_Ads() {
        String userID = pref.getString(Duo_Ads, "off");
        return userID;
    }

    public String getQureka_Inter() {
        String userID = pref.getString(Qureka_Inter, "off");
        return userID;
    }

    public String getQureka_Inter_Mode() {
        String userID = pref.getString(Qureka_Inter_Mode, "off");
        return userID;
    }

    public String getQureka_Inter_CloseTap() {
        String userID = pref.getString(Qureka_Inter_CloseTap, "off");
        return userID;
    }

    public String getQureka_Url() {
        String userID = pref.getString(Qureka_Url, "https://www.google.com/");
        return userID;
    }

    public void setQureka_Inter(String val) {
        edit.putString(Qureka_Inter, val);
        edit.commit();
    }

    public void setQureka_Inter_Mode(String val) {
        edit.putString(Qureka_Inter_Mode, val);
        edit.commit();
    }

    public void setQureka_Inter_CloseTap(String val) {
        edit.putString(Qureka_Inter_CloseTap, val);
        edit.commit();
    }

    public void setQureka_Url(String val) {
        edit.putString(Qureka_Url, val);
        edit.commit();
    }

    public void setDuo_Ads(String val) {
        edit.putString(Duo_Ads, val);
        edit.commit();
    }
    //-----------------------------------------------------------------------------------------------

    public int getInter_count() {
        return pref.getInt(inter_count, 10);
    }

    public void setInterCnt(int color) {
        edit.putInt(inter_count, color);
        edit.commit();
    }

    public int getBack_cnt() {
        return pref.getInt(back_cnt, 10);
    }

    public void setBack_cnt(int color) {
        edit.putInt(back_cnt, color);
        edit.commit();
    }

    public void logout() {
        edit.clear();
        edit.commit();
    }

    public void putString(String key, String def) {
        edit.putString(key, def);
        edit.commit();
    }

    public void putFile(String key, ArrayList<File> file) {
        edit.putString(key, String.valueOf(file));
        edit.commit();
    }

    public String getFile(String ke, ArrayList<File> f) {
        return pref.getString(ke, f.toString());
    }

    public String getString(String key, String def) {
        return pref.getString(key, def);
    }

    public void putInt(String key, int def) {
        edit.putInt(key, def);
        edit.commit();
    }

    public int getInt(String key) {
        return pref.getInt(key, 0);
    }

    public void setIsFirsttimeUse(boolean downloadList) {
        edit.putBoolean(IS_FIRSTTIME_USE, downloadList);
        edit.commit();
    }

    public boolean isFirstTimeUSe() {
        return pref.getBoolean(IS_FIRSTTIME_USE, true);
    }


    //App Getter----------------------------------------------------
    public String getApp_Country() {
        String userID = pref.getString(App_Country, "off");
        return userID;
    }

    public String getApp_Privacy() {
        String userID = pref.getString(App_Privacy, "off");
        return userID;
    }

    public String getApp_Language() {
        String userID = pref.getString(App_Language, "off");
        return userID;
    }

    public String getApp_Permission() {
        String userID = pref.getString(App_Permission, "off");
        return userID;
    }

    public String getApp_Start() {
        String userID = pref.getString(App_Start, "off");
        return userID;
    }

    public String getApp_Thankyou() {
        String userID = pref.getString(App_Thankyou, "off");
        return userID;
    }

    public String getApp_Exit_Dialoge() {
        String userID = pref.getString(App_Exit_Dialoge, "off");
        return userID;
    }


    //App Setter----------------------------------------------------
    public void setApp_Country(String val) {
        edit.putString(App_Country, val);
        edit.commit();
    }

    public void setApp_Privacy(String val) {
        edit.putString(App_Privacy, val);
        edit.commit();
    }

    public void setApp_Language(String val) {
        edit.putString(App_Language, val);
        edit.commit();
    }

    public void setApp_Permission(String val) {
        edit.putString(App_Permission, val);
        edit.commit();
    }

    public void setApp_Start(String val) {
        edit.putString(App_Start, val);
        edit.commit();
    }

    public void setApp_Thankyou(String val) {
        edit.putString(App_Thankyou, val);
        edit.commit();
    }

    public void setApp_Exit_Dialoge(String val) {
        edit.putString(App_Exit_Dialoge, val);
        edit.commit();

    }



    //Call----------------
    public String getIsLongApp() {
        String userID = pref.getString(IsLongApp, "off");
        return userID;
    }
    public String getVideo_call() {
        String userID = pref.getString(Video_call, "off");
        return userID;
    }
    public String getIncoming_Welcome() {
        String userID = pref.getString(Incoming_Welcome, "off");
        return userID;
    }
    public String getIncoming_Counter() {
        String userID = pref.getString(Incoming_Counter, "0");
        return userID;
    }



    public void setIsLongApp(String val) {
        edit.putString(IsLongApp, val);
        edit.commit();

    }
    public void setVideo_call(String val) {
        edit.putString(Video_call, val);
        edit.commit();

    }
    public void setIncoming_Welcome(String val) {
        edit.putString(Incoming_Welcome, val);
        edit.commit();

    }
    public void setIncoming_Counter(String val) {
        edit.putString(Incoming_Counter, val);
        edit.commit();

    }

}
