package com.fasetime.video.audio.sdk_appscreen;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.fasetime.video.audio.sdk_main.sdk_main_c;
import com.fasetime.video.audio.R;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;


public class sdk_app_i extends AppCompatActivity {

    ImageView iv_set4;
    boolean permissionFlag;
    TextView tvAccept;
    RelativeLayout rel_44;
    boolean isCam;
    pro_sdk_c transMainPref;
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sdk_app_c);

        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        }

        transMainPref = new pro_sdk_c(this);
        init();
        setDone();

        this.rel_44.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    iv_set4.setImageResource(R.drawable.ic_check1);
                    isCam = true;
                } else {
                    setPermission();
                }

            }
        });

        TextView textView = (TextView) findViewById(R.id.imgStart);
        this.tvAccept = textView;

        this.tvAccept.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                goNext();
//                if (isstorage) {
//                    goNext();
//                } else {
//                    setPermission();
//                }
            }
        });
    }

    private void goNext() {
        if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
            startActivity(new Intent(sdk_app_i.this, sdk_app_f.class).putExtra("app_inter", true));
        } else {
            startActivity(new Intent(sdk_app_i.this, new sdk_main_c().activity_X).putExtra("app_inter", true));
        }
    }

    public void setPermission() {
        ActivityCompat.requestPermissions(sdk_app_i.this, new String[]{Manifest.permission.CAMERA}, 1000);
    }

    private void setDone() {
      if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            isCam = true;
            iv_set4.setImageResource(R.drawable.ic_check1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0) {

                        boolean camera_ = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                        if (camera_) {
                            isCam = true;
                            iv_set4.setImageResource(R.drawable.ic_check1);
                        }
                        if (camera_) {
                            goNext();

                        }

                }


                break;

        }
    }

    public void init() {
        this.permissionFlag = false;
        rel_44 = findViewById(R.id.rel_44);

        this.iv_set4 = findViewById(R.id.iv_set4);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sdk_app_h.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sdk_app_d.class).putExtra("app_inter", true));
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