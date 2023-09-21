package com.fasetime.video.audio.sdk_appscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fasetime.video.audio.BuildConfig;
import com.fasetime.video.audio.sdk_main.sdk_main_c;
import com.fasetime.video.audio.R;
import com.fasetime.video.audio.sdk_main.sdk_main_b;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;


public class sdk_app_f extends AppCompatActivity {

    ImageView imgStart, imgShare, imgRate, imgPrivacy;
    pro_sdk_c transMainPref;
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    public static boolean isNetworkConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdk_app_e);

        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        }

        transMainPref = new pro_sdk_c(this);
        init();
        setListener();


    }

    private void setListener() {

        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sdk_app_f.this, new sdk_main_c().activity_X).putExtra("app_inter", true));
            }
        });

        imgRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "android.intent.action.VIEW";
                String sb = "market://details?id=" + BuildConfig.APPLICATION_ID;
                Intent intent = new Intent(str, Uri.parse(sb));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    String sb2 = "http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
                    startActivity(new Intent(str, Uri.parse(sb2)));
                }
            }
        });

        imgShare.setOnClickListener(new sdk_main_b() {
            @Override
            public void performClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception ignore) {
                }
            }
        });

        imgPrivacy.setOnClickListener(new sdk_main_b() {
            @Override
            public void performClick(View v) {

                if (isNetworkConnected(sdk_app_f.this)) {
                    final Dialog dialog = new Dialog(sdk_app_f.this);
                    dialog.setContentView(R.layout.sdk_app_j);
                    dialog.setCancelable(true);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    WebView webView = dialog.findViewById(R.id.webView1);
                    webView.loadUrl("https://jahirahmadpolicy.blogspot.com/2023/07/this-privacy-policy-privacy-policy-is.html");

                    webView.setWebViewClient(new WebViewClient() {
                        public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                            viewx.loadUrl(urlx);
                            return false;
                        }
                    });
                    (dialog.findViewById(R.id.no)).setOnClickListener(v1 -> dialog.dismiss());
                    dialog.show();
                } else {
                    Toast.makeText(sdk_app_f.this, "Check Your Internet Connection!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void init() {
        imgStart = findViewById(R.id.imgStart);
        imgShare = findViewById(R.id.imgShare);
        imgRate = findViewById(R.id.imgRate);
        imgPrivacy = findViewById(R.id.imgPrivacy);

    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sdk_app_i.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sdk_app_h.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sdk_app_i.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Country().equalsIgnoreCase("on")) {
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
