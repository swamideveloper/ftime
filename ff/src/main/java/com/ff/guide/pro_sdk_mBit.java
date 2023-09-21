package com.ff.guide;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.ff.guide.mukesh_ads.pro_sdk_d;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;

public class pro_sdk_mBit extends Application {

    private static pro_sdk_mBit mInstance;

    public static synchronized pro_sdk_mBit getInstance() {
        return mInstance;
    }

    public static boolean isConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            return nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
        } catch (Exception e) {
            //Log.e("Connectivity Exception", e.getMessage());
            return false;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (isConnected(this)) {
            AudienceNetworkAds.initialize(this);
            MobileAds.initialize(this, initializationStatus -> {
            });
            MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(pro_sdk_i.TestDeviceID).build());
            new pro_sdk_d(this);
        }
    }
}
