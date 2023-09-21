package com.fasetime.video.audio.sdk_main;

import android.content.Context;

import com.ff.guide.pro_sdk_mBit;


public class sdk_main_a extends pro_sdk_mBit {
    public static sdk_main_a garbaaavechebahiLoan_MBit;
    public static Context context = null;


    public static synchronized sdk_main_a getInstance() {
        sdk_main_a SFLoanMBit;
        synchronized (sdk_main_a.class) {
            SFLoanMBit = garbaaavechebahiLoan_MBit;
        }
        return SFLoanMBit;
    }

    public static Context getContext() {
        return context;
    }

    public void onCreate() {
        super.onCreate();
        garbaaavechebahiLoan_MBit = this;
        context = getApplicationContext();

    }
}
