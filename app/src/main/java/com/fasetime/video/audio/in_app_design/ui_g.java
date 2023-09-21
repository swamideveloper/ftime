package com.fasetime.video.audio.in_app_design;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import com.fasetime.video.audio.R;
import com.fasetime.video.audio.in_app_call_service.service_a;
import com.fasetime.video.audio.in_app_call_service.service_b;

import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;


public class ui_g extends AppCompatActivity {

    pro_sdk_c transMainPref;
    private AppCompatButton welcome;

    //incoming call
    public static int incoming_counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_h);

        transMainPref = new pro_sdk_c(this);

        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.adsContainer));


        welcome = findViewById(R.id.welcome);


        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isStoragePermissionGranted(0)) {

                    if (transMainPref.getIncoming_Welcome().equalsIgnoreCase("on") && incoming_counter == -1) {
                        startActivity(new Intent(ui_g.this, service_a.class));
                    } else {
                        if (transMainPref.getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                            startActivity(new Intent(ui_g.this, service_a.class));
                        } else {
                            if (transMainPref.getIsLongApp().equalsIgnoreCase("on")) {
                                startActivity(new Intent(ui_g.this, ui_d.class));
                            } else {
                                startActivity(new Intent(ui_g.this, service_b.class));
                            }
                        }
                    }


                }
            }
        });

    }

    public boolean isStoragePermissionGranted(int request) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {
                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.CAMERA
                        , Manifest.permission.INTERNET}, request);
                return false;
            }
        } else {
            Log.v("TAG", "Permission is granted");
            return true;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        pro_sdk_i.ShowInterstitialAdsOnBack(this);
    }
}