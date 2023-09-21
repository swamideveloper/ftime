package com.fasetime.video.audio.sdk_appscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fasetime.video.audio.sdk_main.sdk_main_c;
import com.fasetime.video.audio.R;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;

import java.util.ArrayList;

public class sdk_app_c extends AppCompatActivity {

    RecyclerView rvV;
    ArrayList<sdk_app_j> loaned_F_Loan_MCS;
    pro_sdk_c transMainPref;
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdk_app_a);

        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.native_container));

        if (getIntent().getBooleanExtra("app_inter", false)) {
            pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        }

        transMainPref = new pro_sdk_c(this);
        addData();
        init();
    }

    private void addData() {
        loaned_F_Loan_MCS = new ArrayList<>();
        loaned_F_Loan_MCS.add(new sdk_app_j("United Kingdom", "gb", R.drawable.uk));
        loaned_F_Loan_MCS.add(new sdk_app_j("United States", "us", R.drawable.us));
        loaned_F_Loan_MCS.add(new sdk_app_j("Canada", "ca", R.drawable.canada));
        loaned_F_Loan_MCS.add(new sdk_app_j("Australia", "au", R.drawable.au));
        loaned_F_Loan_MCS.add(new sdk_app_j("Switzerland", "ch", R.drawable.ch));
        loaned_F_Loan_MCS.add(new sdk_app_j("World Wide", "all", R.drawable.globalcall));
    }

    private void init() {
        rvV = findViewById(R.id.rvV);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvV.setLayoutManager(gridLayoutManager);

        sdk_app_g countryAdapter = new sdk_app_g(this, loaned_F_Loan_MCS, new sdk_app_a() {
            @Override
            public void callback(String code) {
                if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
                    startActivity(new Intent(sdk_app_c.this, sdk_app_d.class).putExtra("app_inter", true));
                } else if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
                    startActivity(new Intent(sdk_app_c.this, sdk_app_h.class).putExtra("app_inter", true));
                } else if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
                    startActivity(new Intent(sdk_app_c.this, sdk_app_i.class).putExtra("app_inter", true));
                } else if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
                    startActivity(new Intent(sdk_app_c.this, sdk_app_f.class).putExtra("app_inter", true));
                } else {
                    startActivity(new Intent(sdk_app_c.this, new sdk_main_c().activity_X).putExtra("app_inter", true));
                }
            }
        });

        rvV.setAdapter(countryAdapter);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Exit_Dialoge().equalsIgnoreCase("on")) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.sdk_app_i);
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Window window = dialog.getWindow();
            WindowManager.LayoutParams wlp = window.getAttributes();
            dialog.setCancelable(true);
            wlp.gravity = Gravity.BOTTOM;
            window.setAttributes(wlp);

            Trans_Aud_Id.NativeAddShow(this, dialog.findViewById(R.id.native_container));

            TextView txt_yes = dialog.findViewById(R.id.yes);
            txt_yes.setOnClickListener(v -> {
                dialog.dismiss();
                if (transMainPref.getApp_Thankyou().equalsIgnoreCase("on")) {
                    startActivity(new Intent(this, sdk_app_b.class).putExtra("app_inter", true));
                } else {
                    finishAffinity();
                }
            });
            dialog.show();
        } else {
            if (doubleBackToExitPressedOnce) {
                ((Activity) context).finishAffinity();
                System.exit(1);
                return;
            }

            doubleBackToExitPressedOnce = true;
            Toast.makeText(context, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }

    }

}
