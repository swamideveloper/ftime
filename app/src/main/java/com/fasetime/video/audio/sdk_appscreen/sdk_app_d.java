package com.fasetime.video.audio.sdk_appscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fasetime.video.audio.sdk_main.sdk_main_c;
import com.fasetime.video.audio.R;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;


public class sdk_app_d extends AppCompatActivity {


    TextView tvAccept, textView, iv_close;
    TextView tv_policy1, tv_policy2, tv_policy3, tv_diffaccept;
    pro_sdk_c transMainPref;
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdk_app_d);

        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        }

        transMainPref = new pro_sdk_c(this);
        init();

        String str1 = "Following link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/terms-conditions.html\"> <b> Terms and conditions of use </b> </a> ";
        tv_policy1.setText(Html.fromHtml(str1));
        tv_policy1.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy1.setMovementMethod(LinkMovementMethod.getInstance());

        String str2 = "Following Link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/privacy-policy.html\"> <b> Privacy policy </b> </a> ";
        tv_policy2.setText(Html.fromHtml(str2));
        tv_policy2.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy2.setMovementMethod(LinkMovementMethod.getInstance());

        String str3 = "Following Link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/app-community-guidelines.html\"> <b> App Community Guidelines </b> </a> ";
        tv_policy3.setText(Html.fromHtml(str3));
        tv_policy3.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy3.setMovementMethod(LinkMovementMethod.getInstance());

        iv_close.setOnClickListener(v -> onBackPressed());

        tvAccept.setOnClickListener(v -> {
            if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
                startActivity(new Intent(sdk_app_d.this, sdk_app_h.class).putExtra("app_inter", true));
            } else if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
                startActivity(new Intent(sdk_app_d.this, sdk_app_i.class).putExtra("app_inter", true));
            } else if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
                startActivity(new Intent(sdk_app_d.this, sdk_app_f.class).putExtra("app_inter", true));
            } else {
                startActivity(new Intent(sdk_app_d.this, new sdk_main_c().activity_X).putExtra("app_inter", true));
            }
        });
    }

    private void init() {
        iv_close = findViewById(R.id.iv_close);
        tvAccept = findViewById(R.id.tvText);
        textView = findViewById(R.id.textView);
        tv_policy1 = findViewById(R.id.tv_policy1);
        tv_policy2 = findViewById(R.id.tv_policy2);
        tv_policy3 = findViewById(R.id.tv_policy3);
        tv_diffaccept = findViewById(R.id.tv_diffaccept);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Country().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sdk_app_c.class).putExtra("app_inter", true));
            finish();
        } else {
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

}
